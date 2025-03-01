package com.ashv.ats.resumebuilder.model;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.*;
import org.springframework.lang.NonNull;
public class VerifyUserRequestModel {
    
    private String requestId;
    private String userId;
    private int otp;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

     public void setOtp(int otp) {
        this.otp = otp;
    }

    public int getOtp() {
        return otp;
    }
}
