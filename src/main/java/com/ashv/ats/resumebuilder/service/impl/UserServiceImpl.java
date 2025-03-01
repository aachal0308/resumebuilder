package com.ashv.ats.resumebuilder.service.impl;

import com.ashv.ats.resumebuilder.model.*;
import org.springframework.stereotype.Service;
import com.ashv.ats.resumebuilder.entity.UserEntity;
import com.ashv.ats.resumebuilder.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.time.LocalDateTime;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;

    public UserEntity getUser(String userId) {
        return userRepository.get(userId);
    }
    public LoginResponseModel login(LoginRequestModel request) {
        UserEntity user = userRepository.getUserByUsername(request.getUsername());
        if(user==null) {
            throw new InvalidCredentialException();
        }
        if(!user.getPassword().equals(request.getPassword()) {
            throw new InvalidCredentialException();
        }
        return new LoginResponseModel(user);
    }
    public void createUser(CreateUserRequestModel request) {
        UserEntity user = request.getUser();
        user.setStatus(UserEntity.Status.NOT_VERIFIED);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setId(UUID.randomUUID().toString());
        userRepository.create(user);
    }
    public void updateUser(UpdateUserRequestModel request) {
        UserEntity old = userRepository.get(userId);
        UserEntity new = request.getUser();
        boolean isUpdated = false;
        if(shouldUpdate(old.getFirstName(),new.getFirstName())) {
            old.setFirstName(new.getFirstName());
            isUpdated = true;
        }
        if(shouldUpdate(old.getLastName(),new.getLastName())) {
            old.setLastName(new.getLastName());
            isUpdated = true;
        }
        if(shouldUpdate(old.getEmail(),new.getEmail())) {
            old.setLastName(new.getLastName());
            old.setStatus(UserEntity.Status.NOT_VERIFIED);
            isUpdated = true;
        }
        if(isUpdated) {
            old.setUpdatedAt(LocalDateTime.now());
            userRepository.update(old);
        }
    }
    public void deleteUser(String userId) {
        userRepository.delete(userId);
    }


    private boolean shouldUpdate(String oldString, String newString) {
        if(newString!=null  && !newString.isEmpty() && !newString.equals(oldString)) {
            return true;
        }
        return false;
    }
}
