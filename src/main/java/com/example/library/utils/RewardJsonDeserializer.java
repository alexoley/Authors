package com.example.library.utils;

import com.example.library.entity.Reward;
import com.example.library.repositories.AuthorRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RewardJsonDeserializer extends StdDeserializer<Reward> {
    @Autowired
    private AuthorRepository authorRepository;

    public RewardJsonDeserializer() {
        this(null);
    }

    public RewardJsonDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Reward deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        int year = (Integer) (node.get("year")).numberValue();
        String title = node.get("title").asText();
        int author_id = (Integer) ( node.get("author_id")).numberValue();
        return new Reward(year, title, authorRepository.findById(author_id).get());
    }
}
