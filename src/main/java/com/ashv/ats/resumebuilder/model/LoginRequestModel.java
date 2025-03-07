package com.ashv.ats.resumebuilder.model;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.*;
import org.springframework.lang.NonNull;

public class LoginRequestModel {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}