package com.example.author.services;

import com.example.author.entity.Author;
import com.example.author.entity.AuthorShort;
import com.example.author.entity.Book;
import com.example.author.entity.Reward;
import com.example.author.entity.enums.Enums;
import com.example.author.exceptions.NoValidDateException;
import com.example.author.repositories.BookRepository;
import com.example.author.repositories.RewardRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public interface AuthorService {

    Iterable<Author> getAllAuthors();

    Optional<AuthorShort> shortInfo (Integer id);

    Optional<Author> getAuthor (Integer id);

    ResponseEntity<Author> createAuthor(String json);

    ResponseEntity<Author> updateAuthor(String json, Integer id);

}
