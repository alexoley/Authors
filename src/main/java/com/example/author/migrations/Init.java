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
        Configuration hibernateConfiguration = new Configuration();

        hibernateConfiguration.addAnnotatedClass(myEntity.class);
        Reward rew = new Reward();
        rew.setTitle("For reading");
        rew.setYear(1885);
        rewardRepository.save(rew);
    }
}
