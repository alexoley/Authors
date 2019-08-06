package com.example.library.services.impl;

import com.example.library.entity.Reward;
import com.example.library.repositories.RewardRepository;
import com.example.library.services.RewardService;
import com.example.library.utils.RewardJsonDeserializer;
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
@Qualifier("rewardServiceImpl")
public class RewardServiceImpl implements RewardService {

    @Autowired
    private RewardRepository rewardRepository;

    @Autowired
    private RewardJsonDeserializer rewardJsonDeserializer;

    public ResponseEntity<Reward> createReward(String json) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Reward.class, rewardJsonDeserializer);
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

    public ResponseEntity<Reward> updateReward(String json, Integer id) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Reward.class, rewardJsonDeserializer);
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

    public Optional<Reward> getReward (Integer id) {
        return rewardRepository.findById(id);

    }

    public Iterable<Reward> getAllRewards () {
        return rewardRepository.findAll();

    }
}
