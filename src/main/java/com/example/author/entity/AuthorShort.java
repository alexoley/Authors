package com.example.author.entity;

import org.springframework.beans.factory.annotation.Value;

import java.util.*;

public interface AuthorShort {

    String getFirstName();

    String getLastName();

    List<BookTitle> getBooks();

    @Value("#{@authorShortUtil.getAgeUt(target)}")
    Long getAge();

    interface BookTitle {
        String getTitle();
    }
}
