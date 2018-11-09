package com.example.author.controllers;

import com.example.author.entity.Author;
import com.example.author.entity.Book;
import com.example.author.entity.Reward;
import com.example.author.repositories.BookRepository;
import com.example.author.services.BookService;
import com.example.author.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping(path="/book")
@Secured("USER")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @GetMapping(path="")
    @ResponseBody
    public Iterable<Book>
    getAllBooks(){
        return bookRepository.findAll();
    }

    @GetMapping(path="/{id}")
    @ResponseBody
    public Optional<Book> getAuthor (@PathVariable Integer id) {
        return bookRepository.findById(id);

    }

    @PostMapping("")
    public ResponseEntity<Book> createBook(@RequestBody String json) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Book.class, bookService);
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

    @PutMapping("/{id}")
    public ResponseEntity<Book> createReward(@RequestBody String json,
                                               @PathVariable Integer id) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Book.class, bookService);
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
