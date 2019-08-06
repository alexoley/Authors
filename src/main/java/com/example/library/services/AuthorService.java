package com.example.library.services;

import com.example.library.entity.Author;
import com.example.library.entity.AuthorShort;
import org.springframework.http.ResponseEntity;

import java.util.*;

public interface AuthorService {

    Iterable<Author> getAllAuthors();

    Optional<AuthorShort> shortInfo (Integer id);

    Optional<Author> getAuthor (Integer id);

    ResponseEntity<Author> createAuthor(String json);

    ResponseEntity<Author> updateAuthor(String json, Integer id);

}
