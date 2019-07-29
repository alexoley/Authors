package com.example.author.services.impl;


import com.example.author.entity.Author;
import com.example.author.entity.AuthorShort;
import com.example.author.repositories.AuthorRepository;
import com.example.author.services.AuthorService;
import com.example.author.utils.AuthorJsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@Qualifier("authorServiceImpl")
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    AuthorJsonDeserializer authorJsonDeserializer;

    public Iterable<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<AuthorShort> shortInfo(Integer id) {
        return authorRepository.findShortById(id);
    }

    public Optional<Author> getAuthor(Integer id) {
        return authorRepository.findById(id);
    }

    public ResponseEntity<Author> createAuthor(String json) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Author.class, authorJsonDeserializer);
        mapper.registerModule(module);
        try {
            Author author = mapper.readValue(json, Author.class);
            Author savedAuthor = authorRepository.save(author);
            return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED);
        }
        catch(IOException e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Author> updateAuthor(String json, Integer id) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Author.class, authorJsonDeserializer);
        mapper.registerModule(module);
        try {
            Author author = mapper.readValue(json, Author.class);
            author.setId(id);
            //Author savedAuthor = authorRepository.save(author);
            Author savedAuthor = authorRepository.saveAndFlush(author);
            return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED);
        }
        catch(IOException e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
