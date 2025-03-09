package com.ashv.ats.resumebuilder.entity;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.*;
import org.springframework.lang.NonNull;
import java.time.LocalDateTime;

public class SessionEntity {

    private String id;

    private String userId;

    private long lastUsed;

    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return id;
    }
    
    public void setUserId(String userId){
        this.userId=userId;
    }
    public String getUserId(){
        return userId;
    }

    public void setLastUsed(long lastUsed){
        this.lastUsed=lastUsed;
    }
    public long getLastUsed(){
        return lastUsed;
    }
}