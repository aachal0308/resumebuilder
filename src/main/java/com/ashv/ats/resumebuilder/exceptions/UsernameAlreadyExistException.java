package com.ashv.ats.resumebuilder.exceptions; 

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UsernameAlreadyExistException extends RuntimeException {

    public UsernameAlreadyExistException(String username) {
        super("Username: " + username + " not avaliable, please try something different"); 
    }
}