package com.example.author.migrations;

import com.example.author.entity.Reward;
import com.example.author.repositories.RewardRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.security.auth.login.Configuration;

@Component
public class Init implements InitializingBean {

    @Autowired
    private RewardRepository rewardRepository;

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
