package com.ashv.ats.resumebuilder.model;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.*;
import org.springframework.lang.NonNull;
public class UpdateUserRequestModel {
    
    private String requestId;
    private UserEntity user;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public UserEntity getUser() {
        return user;
    }
}
