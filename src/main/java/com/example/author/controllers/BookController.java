package com.example.author.controllers;

import com.example.author.entity.Book;
import com.example.author.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping(path="/book")
@Secured("USER")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

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


}
