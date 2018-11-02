package com.example.author.controllers;

import com.example.author.entity.Author;
import com.example.author.entity.Reward;
import com.example.author.repositories.AuthorRepository;
import com.example.author.repositories.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@Controller
@RequestMapping(path="/author")
@Secured("USER")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private RewardRepository rewardRepository;

    @GetMapping(path="")
    @ResponseBody
    public Iterable<Author>
    getAllAuthors(){
        return authorRepository.findAll();
    }

    @GetMapping(path="/info/short/{id}")
    @ResponseBody
    public Optional<Author> shortInfo (@PathVariable Integer id) {
        return authorRepository.shortInfo();

    }

    @GetMapping(path="/{id}")
    @ResponseBody
    public Optional<Author> getAuthor (@PathVariable Integer id) {
        return authorRepository.findById(id);

    }

    @PostMapping("")
    public ResponseEntity<Object> createNote(@Valid @RequestBody Author author) {
        Author savedAuthor = authorRepository.save(author);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedAuthor.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(path="/reward")
    @ResponseBody
    public Iterable<Reward> getAllRewards () {
        return rewardRepository.findAll();

    }

    @GetMapping(path="/reward/{id}")
    @ResponseBody
    public Optional<Reward> getReward (@PathVariable Integer id) {
        return rewardRepository.findById(id);

    }
}
