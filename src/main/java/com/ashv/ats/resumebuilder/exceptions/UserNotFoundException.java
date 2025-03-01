package com.ashv.ats.resumebuilder.exceptions; 

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) 
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("User Not Found"); 
    }

    public UserNotFoundException(String message) {
        super(message); 
    }
}

//"User with username: " + username + " doesn't exist, please signup"