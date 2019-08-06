package com.example.library.controllers;

import com.example.library.entity.Book;
import com.example.library.entity.enums.Enums;
import com.example.library.repositories.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookControllerTests {

    @Autowired
    private BookController bookController;

    @Autowired
    private BookRepository bookRepository;

    Book oneHundredYearsOfSolitude = new Book();

    @Before
    public void init(){
        oneHundredYearsOfSolitude.setTitle("One Hundred Years of Solitude");
        oneHundredYearsOfSolitude.setGenre(Enums.genre.Magic_realism);
        oneHundredYearsOfSolitude.setISBN("9789631420494");
        bookRepository.save(oneHundredYearsOfSolitude);
    }

    @Test
    public void bookTest(){
        assertEquals(oneHundredYearsOfSolitude.getTitle(),
                bookController.getBook(6).get().getTitle());
        assertEquals(oneHundredYearsOfSolitude.getISBN(),
                bookController.getBook(6).get().getISBN());
    }
}