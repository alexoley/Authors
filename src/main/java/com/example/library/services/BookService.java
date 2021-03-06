package com.example.library.services;


import com.example.library.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface BookService  {

    Iterable<Book> getAllBooks();

    Optional<Book> getBook (Integer id);

    ResponseEntity<Book> createBook(String json);

    ResponseEntity<Book> updateBook(String json, Integer id);
}
