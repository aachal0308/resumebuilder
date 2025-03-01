package com.ashv.ats.resumebuilder.model;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.*;
import org.springframework.lang.NonNull;
import com.ashv.ats.resumebuilder.entity.UserEntity.Status;
import com.ashv.ats.resumebuilder.entity.UserEntity;

public class LoginResponseModel {

    private String id;
    private String username;
    private String name;
    public Status status;
    public String session;

    public LoginResponseModel() {}
    public LoginResponseModel(UserEntity user, String sessionId) {
        id = user.getId();
        username = user.getUsername();
        name = user.getFirstName() + " " + user.getLastName();
        status = user.getStatus();
        session = sessionId;
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

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

    public void setStatus(Status status){
        this.status=status;
    }
    public Status getStatus(){
        return status;
    }

    public void setSession(String session){
        this.session=session;
    }
    public String getSession(){
        return session;
    }
}