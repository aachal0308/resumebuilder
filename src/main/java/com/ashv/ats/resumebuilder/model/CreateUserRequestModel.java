package com.ashv.ats.resumebuilder.model;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.*;
import org.springframework.lang.NonNull;
public class CreateUserRequestModel {
    @NotEmpty
    private String id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return id;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername(){
        return username;
    }
}
