package com.ashv.ats.resumebuilder.service;

import com.ashv.ats.resumebuilder.model.CreateUserRequestModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    private final Map<String, CreateUserRequestModel> userStorage = new HashMap<>();
    @Override
    public void createUser(CreateUserRequestModel user) {
        userStorage.put(user.getId(), user);
    }
    @Override
    public Optional<CreateUserRequestModel> getUserById(String userId) {
        return Optional.ofNullable(userStorage.get(userId));
    }
}
