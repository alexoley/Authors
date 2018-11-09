package com.example.author.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoValidDateException extends IOException{
    public NoValidDateException(String message){
        super(message);
    }
}
