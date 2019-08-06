package com.example.library.services;

import com.example.library.entity.Reward;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface RewardService{

    ResponseEntity<Reward> createReward(String json);

    ResponseEntity<Reward> updateReward(String json, Integer id);

    Optional<Reward> getReward (Integer id);

    Iterable<Reward> getAllRewards ();
}
