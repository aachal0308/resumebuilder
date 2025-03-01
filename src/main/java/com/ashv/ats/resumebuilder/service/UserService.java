package com.ashv.ats.resumebuilder.service;

import com.ashv.ats.resumebuilder.model.*;
import com.ashv.ats.resumebuilder.entity.UserEntity;

public interface UserService {
    public UserEntity getUser(String userId);
    public LoginResponseModel login(LoginRequestModel request);
    public void createUser(CreateUserRequestModel request);
    public void updateUser(UpdateUserRequestModel request);
    public void deleteUser(String userId);
}
