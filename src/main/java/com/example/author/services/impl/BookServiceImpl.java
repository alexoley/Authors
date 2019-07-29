package com.example.author.services.impl;

import com.example.author.entity.Book;
import com.example.author.repositories.BookRepository;
import com.example.author.services.BookService;
import com.example.author.utils.BookJsonDeserializer;
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
@Qualifier("bookServiceImpl")
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookJsonDeserializer bookJsonDeserializer;

    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBook(Integer id) {
        return bookRepository.findById(id);
    }

    public ResponseEntity<Book> createBook(String json) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Book.class, bookJsonDeserializer);
        mapper.registerModule(module);
        try {
            Book book = mapper.readValue(json, Book.class);
            Book savedBook = bookRepository.save(book);
            return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
        }
        catch(IOException e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Book> updateBook(String json, Integer id) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Book.class, bookJsonDeserializer);
        mapper.registerModule(module);
        try {
            Book book = mapper.readValue(json, Book.class);
            book.setId(id);
            Book savedBook = bookRepository.save(book);
            return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
        }
        catch(IOException e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
