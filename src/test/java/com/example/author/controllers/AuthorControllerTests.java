package com.example.author.controllers;

import com.example.author.entity.Author;
import com.example.author.entity.enums.Enums;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
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

    @Test
    public void getAuthorTest()
    {
        Author agata = new Author();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-M-dd");

        try {
            Date birthDate = dateformat.parse("1890-09-15");
            agata.setBirthDate(birthDate);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        agata.setFirstName("Agatha");
        agata.setLastName("Christie");
        agata.setSex(Enums.sex.FEMALE);
        assertEquals(agata,authorController.getAuthor(5).get());
    }
}
