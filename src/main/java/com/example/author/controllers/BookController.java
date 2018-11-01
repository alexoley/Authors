package com.example.author.controllers;

import com.example.author.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/book") // This means URL's start with /demo (after Application path)
@Secured("USER")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewUser () {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return "book";

    }

    @GetMapping(path="/all")
    public @ResponseBody String getAllUsers() {
        // This returns a JSON or XML with the users
        return "allbook";
    }
}
