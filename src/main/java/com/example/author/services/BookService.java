package com.example.author.services;

import com.example.author.entity.Author;
import com.example.author.entity.Book;
import com.example.author.entity.enums.Enums;
import com.example.author.repositories.AuthorRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService extends StdDeserializer<Book> {

    @Autowired
    private AuthorRepository authorRepository;

    public BookService() {
        this(null);
    }

    public BookService(Class<?> vc) {
        super(vc);
    }

    public Book deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException{
        JsonNode node = jp.getCodec().readTree(jp);
        String title = node.get("title").asText();
        String ISBN = node.get("ISBN").asText();
        String genreText = node.get("genre").asText();
        Enums.genre genre = Enums.genre.valueOf(genreText);
        JsonNode authorsNode = node.get("authors");
        List<Author> authors = new ArrayList<>();
        if(authorsNode.isArray()) {
            for (JsonNode id : authorsNode) {
                authors.add(authorRepository.findById(id.intValue()).get());
            }
        }
        return new Book(title, ISBN, genre, authors);
    }
}
