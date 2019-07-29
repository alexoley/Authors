package com.example.author.utils;

import com.example.author.entity.Author;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class AuthorShortUtil {
    public Long getAgeUt(Author a){
        if(a.getBirthDate()!=null){
            Date now = new Date();
            long diffInMillies = Math.abs(now.getTime()-a.getBirthDate().getTime());
            return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS)/365L;
        }
        return null;
    }
}