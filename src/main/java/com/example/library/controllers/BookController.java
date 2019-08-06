package com.example.library.controllers;

import com.example.library.entity.Book;
import com.example.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/book")
@Secured("USER")
public class BookController {

    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    @GetMapping(path="")
    @ResponseBody
    public Iterable<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping(path="/{id}")
    @ResponseBody
    public Optional<Book> getBook (@PathVariable Integer id) {
        return bookService.getBook(id);
    }

    @PostMapping("")
    public ResponseEntity<Book> createBook(@RequestBody String json) {
        return bookService.createBook(json);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody String json,
                                           @PathVariable Integer id) {
        return bookService.updateBook(json, id);
    }


}
