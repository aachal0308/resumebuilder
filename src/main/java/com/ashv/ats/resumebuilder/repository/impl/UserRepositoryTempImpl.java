package com.ashv.ats.resumebuilder.repository.impl;

import com.ashv.ats.resumebuilder.entity.UserEntity;
import org.springframework.stereotype.Component;
import com.ashv.ats.resumebuilder.exceptions.*;

@Component
public class UserRepositoryTempImpl implements UserRepository {
    
    private Map<String, UserEntity> idUserMap = new HashMap<>();
    private Map<String, UserEntity> usernameUserMap = new HashMap<>();
    private Map<String, UserEntity> emailUserMap = new HashMap<>();


    public UserEntity get(String userId) {
        UserEntity user = idUserMap.get(userId);
        if(user==null) {
            throw new UserNotFoundException();
        }
        return user;
    }
    public UserEntity getUserByUsername(String username) {
        UserEntity user = usernameUserMap.get(username);
        if(user==null) {
            user = emailUserMap.get(username);
        }
        return user;
    }
    public void create(UserEntity user) {
        idUserMap.put(user.getId(), user);
        if(emailUserMap.get(user.getEmail())!=null) 
            throw new UserAlreadyExistException(user.getEmail());
        if(username.get(user.getUsername())!=null) 
            throw new UsernameAlreadyExistException(user.getUsername());
        emailUserMap.put(user.getEmail(), user);
        username.put(user.getUsername(), user);
        
    }
    public void update(UserEntity user) {

    }
    public void delete(String userId) {
        UserEntity user = idUserMap.get(userId);
        idUserMap.remove(user.getId());
        username.remove(user.getUsername());
        emailUserMap.remove(user.getEmail());
    }
}
