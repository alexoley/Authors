package com.example.author.controllers;

import com.example.author.entity.Author;
import com.example.author.entity.AuthorShort;
import com.example.author.entity.Reward;
import com.example.author.repositories.AuthorRepository;
import com.example.author.repositories.RewardRepository;
import com.example.author.services.AuthorService;
import com.example.author.services.RewardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/author")
@Secured("USER")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private RewardRepository rewardRepository;

    @Autowired
    private RewardService rewardService;

    @Autowired
    private AuthorService authorService;

    @GetMapping(path="")
    @ResponseBody
    public Iterable<Author>
    getAllAuthors(){
        return authorRepository.findAll();
    }

    @GetMapping(path="/info/short/{id}")
    @ResponseBody
    public List<AuthorShort> shortInfo (@PathVariable Integer id) {
        return authorRepository.findShortById(id);

    }

    @GetMapping(path="/{id}")
    @ResponseBody
    public Optional<Author> getAuthor (@PathVariable Integer id) {
        return authorRepository.findById(id);

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

    @PostMapping("")
    public ResponseEntity<Author> createAuthor(@RequestBody String json) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Author.class, authorService);
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

    @PostMapping("/reward")
    public ResponseEntity<Reward> createReward(@RequestBody String json) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Reward.class, rewardService);
        mapper.registerModule(module);
        try {
            Reward reward = mapper.readValue(json, Reward.class);
            Reward savedReward = rewardRepository.save(reward);
            return new ResponseEntity<>(savedReward, HttpStatus.CREATED);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@RequestBody String json,
                                               @PathVariable Integer id) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Author.class, authorService);
        mapper.registerModule(module);
        try {
            Author author = mapper.readValue(json, Author.class);
            author.setId(id);
            Author savedAuthor = authorRepository.save(author);
            return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED);
        }
        catch(IOException e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/reward/{id}")
    public ResponseEntity<Reward> createReward(@RequestBody String json,
                                               @PathVariable Integer id) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Reward.class, rewardService);
        mapper.registerModule(module);
        try {
            Reward reward = mapper.readValue(json, Reward.class);
            reward.setId(id);
            Reward savedReward = rewardRepository.save(reward);
            return new ResponseEntity<>(savedReward, HttpStatus.CREATED);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
