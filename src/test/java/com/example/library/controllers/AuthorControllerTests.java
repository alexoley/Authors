package com.example.library.controllers;

import com.example.library.entity.Author;
import com.example.library.entity.enums.Enums;
import com.example.library.repositories.AuthorRepository;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorControllerTests {

    @Autowired
    private AuthorController authorController;

    @Autowired
    private AuthorRepository authorRepository;

    private Author tolstoy = new Author();

    private long diffInMillies;

    @Before
    public void init(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd");

        try {
            Date birthDate = dateFormat.parse("1828-09-09");
            tolstoy.setBirthDate(birthDate);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        tolstoy.setFirstName("Leo");
        tolstoy.setLastName("Tolstoy");
        tolstoy.setSex(Enums.sex.MALE);
        authorRepository.saveAndFlush(tolstoy);

        Date now = new Date();
        diffInMillies = Math.abs(now.getTime()-tolstoy.getBirthDate().getTime());
    }

    @Test
    public void authorTest() {
        assertEquals(tolstoy.getFirstName(), authorController.getAuthor(6).get().getFirstName());

        assertEquals(TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS)/365L,
                authorController.shortInfo(6).get().getAge().longValue());
    }
}
