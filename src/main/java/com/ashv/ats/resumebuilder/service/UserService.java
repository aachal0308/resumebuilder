package com.ashv.ats.resumebuilder.service;

import com.ashv.ats.resumebuilder.model.CreateUserRequestModel;
import java.util.Optional;


public interface UserService {
    void createUser(CreateUserRequestModel user);
    Optional<CreateUserRequestModel> getUserById(String userId);
}
