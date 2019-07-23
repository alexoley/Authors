package com.example.author.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.*;

public interface AuthorShort {
    String getFirstName();
    String getLastName();

    List<BookTitle> getBooks();

    @JsonIgnore
    @Temporal(TemporalType.DATE)
    Date getBirthDate();

    default Integer getAge(){
        if(getBirthDate()!=null){
            //Date now = new Date();
            //return ((int)((Calendar.getInstance().getTime().getTime() + getBirthDate().getTime())/10000));
            return (int)(getBirthDate().getTime()/(1000*60*60*24*365));
        }
        return null;
    }

    interface BookTitle {
        String getTitle();
    }
}
