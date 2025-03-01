package com.ashv.ats.resumebuilder.entity;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.*;
import org.springframework.lang.NonNull;
import java.time.LocalDateTime;

public class UserEntity {

    private String id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String firstName;

    private String lastName;

    @NotEmpty
    private String email;

    private Status status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

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

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public String getLastName(){
        return lastName;
    }

    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }

    public void setStatus(Status status){
        this.status=status;
    }
    public Status getStatus(){
        if(status==null) {
            status = Status.NOT_VERIFIED;
        }
        return status;
    }

    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt){
        this.updatedAt=updatedAt;
    }
    public LocalDateTime getUpdatedAt(){
        return updatedAt;
    }

    public enum Status {
        NOT_VERIFIED,
        ACTIVE,
        BLOCKED
    }
}