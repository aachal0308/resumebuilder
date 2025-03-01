package com.ashv.ats.resumebuilder.repository;

import com.ashv.ats.resumebuilder.entity.UserEntity;


public interface UserRepository {
    
    public UserEntity get(String userId);
    public UserEntity getUserByUsername(String username);
    public void create(UserEntity user);
    public void update(UserEntity user);
    public void delete(String userId);
}
