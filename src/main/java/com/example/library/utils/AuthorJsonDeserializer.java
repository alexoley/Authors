package com.example.library.utils;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.entity.Reward;
import com.example.library.entity.enums.Enums;
import com.example.library.exceptions.NoValidDateException;
import com.example.library.repositories.BookRepository;
import com.example.library.repositories.RewardRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Component
public class AuthorJsonDeserializer extends StdDeserializer<Author> {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RewardRepository rewardRepository;

    public AuthorJsonDeserializer() {
        this(null);
    }

    public AuthorJsonDeserializer(Class<?> vc) {
        super(vc);
    }

    public Author deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        String firstName = node.get("firstName").asText();
        String lastName = node.get("lastName").asText();
        String sexText = node.get("sex").asText();
        Enums.sex sex = Enums.sex.valueOf(sexText);
        JsonNode booksNode = node.get("books");
        List<Book> books = new ArrayList<>();
        if(booksNode.isArray()) {
            for (JsonNode id : booksNode) {
                books.add(bookRepository.findById(id.intValue()).get());
            }
        }
        JsonNode rewardsNode = node.get("rewards");
        List<Reward> rewards = new ArrayList<>();
        if(rewardsNode.isArray()) {
            for (JsonNode id : rewardsNode) {
                rewards.add(rewardRepository.findById(id.intValue()).get());
            }
        }
        String birthDateText = node.get("birthDate").asText();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date birthDate = null;
        try {
            birthDate = format.parse(birthDateText);
        } catch (ParseException e) {
            throw new NoValidDateException("Can't parse this Date");
        }
        return new Author(firstName, lastName, sex, books
                , birthDate,rewards);
    }
}
