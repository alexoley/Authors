package com.example.author.entity;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.*;

public interface AuthorShort {
    String getFirstName();
    String getLastName();

    List<BookTitle> getBooks();

    @Temporal(TemporalType.DATE)
    Date getBirthDate();

    interface BookTitle {
        String getTitle();
    }
}
