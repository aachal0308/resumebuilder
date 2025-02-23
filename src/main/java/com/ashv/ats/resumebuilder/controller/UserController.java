package com.ashv.ats.resumebuilder.controller;

import com.ashv.ats.resumebuilder.model.CreateUserRequestModel;
import com.ashv.ats.resumebuilder.service.UserService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/resumebuilder/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;
    Map<String, CreateUserRequestModel> user = new HashMap<>();
    Map<String, String> userSessions = new HashMap<>();
    @PostMapping

    public void create(@RequestBody @Valid CreateUserRequestModel input){
        user.put(input.getId(),input);
    }
    @GetMapping("/{userId}")
    public @ResponseBody CreateUserRequestModel get(@PathVariable("userId")String userId) {
        //business logic
        return user.get(userId);
    }
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        Map<String, String> response = new HashMap<>();
        CreateUserRequestModel user= getUserByUsername(username);
        if (user.getPassword().equals(password)) {
            String sessionId = UUID.randomUUID().toString();
            userSessions.put(username, sessionId);
            return sessionId;
        }
        else {
            throw new RuntimeException("Invalid Password");
        }
    }
    @GetMapping("/check-session/{username}")
    public Map<String, String> checkSession(@PathVariable String username) {
        Map<String, String> response = new HashMap<>();
        String sessionId = userSessions.get(username);
        if (sessionId != null) {
            response.put("sessionId", sessionId);  // Return stored session ID
        }
        else {
            response.put("error", "No session found for user " + username);
        }
        return response;
    }
    private CreateUserRequestModel getUserByUsername(String username){
        Optional<CreateUserRequestModel> optional=user.values().stream().filter(u->u.getUsername().equals(username)).findFirst();
        if(optional.isPresent()) return optional.get();
        throw new RuntimeException("Invalid Username");
    }
}
