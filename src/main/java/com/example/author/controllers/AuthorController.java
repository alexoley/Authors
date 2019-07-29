package com.example.author.controllers;

import com.example.author.entity.Author;
import com.example.author.entity.AuthorShort;
import com.example.author.entity.Reward;
import com.example.author.services.AuthorService;
import com.example.author.services.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping(path="/author")
@Secured("USER")
public class AuthorController {

    @Autowired
    @Qualifier("rewardServiceImpl")
    private RewardService rewardService;

    @Autowired
    @Qualifier("authorServiceImpl")
    private AuthorService authorService;

    @GetMapping(path="")
    @ResponseBody
    public Iterable<Author> getAllAuthors(){

        return authorService.getAllAuthors();
    }

    @GetMapping(path="/info/short/{id}")
    @ResponseBody
    public Optional<AuthorShort> shortInfo (@PathVariable Integer id) {

        return authorService.shortInfo(id);
    }

    @GetMapping(path="/{id}")
    @ResponseBody
    public Optional<Author> getAuthor (@PathVariable Integer id) {
        return authorService.getAuthor(id);

    }

    @GetMapping(path="/reward")
    @ResponseBody
    public Iterable<Reward> getAllRewards () {
        return rewardService.getAllRewards();

    }

    @GetMapping(path="/reward/{id}")
    @ResponseBody
    public Optional<Reward> getReward (@PathVariable Integer id) {
        return rewardService.getReward(id);

    }

    @PostMapping("")
    public ResponseEntity<Author> createAuthor(@RequestBody String json) {
        return authorService.createAuthor(json);
    }

    @PostMapping("/reward")
    public ResponseEntity<Reward> createReward(@RequestBody String json) {
        return rewardService.createReward(json);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@RequestBody String json,
                                               @PathVariable Integer id) {
        return authorService.updateAuthor(json,id);
    }

    @PutMapping("/reward/{id}")
    public ResponseEntity<Reward> updateReward(@RequestBody String json,
                                               @PathVariable Integer id) {
        return rewardService.updateReward(json,id);
    }
}
