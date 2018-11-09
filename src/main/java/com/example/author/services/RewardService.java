package com.example.author.services;

import com.example.author.entity.Author;
import com.example.author.entity.Reward;
import com.example.author.repositories.AuthorRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RewardService extends StdDeserializer<Reward> {

    @Autowired
    private AuthorRepository authorRepository;

    public RewardService() {
        this(null);
    }

    public RewardService(Class<?> vc) {
        super(vc);
    }

    @Override
    public Reward deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException{
        JsonNode node = jp.getCodec().readTree(jp);
        int year = (Integer) ((IntNode) node.get("year")).numberValue();
        String title = node.get("title").asText();
        int author_id = (Integer) ((IntNode) node.get("author_id")).numberValue();
        return new Reward(year, title, authorRepository.findById(author_id).get());
    }
}
