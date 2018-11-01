package com.example.author.controllers;

import com.example.author.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/author") // This means URL's start with /demo (after Application path)
@Secured("USER")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping(path="/info/short/{id}") // Map ONLY GET Requests
    @ResponseBody
    public int shortInfo (@PathVariable int id) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return id;

    }

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewUser () {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return "author";

    }

    @GetMapping(path="/all")
    public @ResponseBody String getAllUsers() {
        // This returns a JSON or XML with the users
        return "allauthor";
    }
}
