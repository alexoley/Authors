package com.example.author.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
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
