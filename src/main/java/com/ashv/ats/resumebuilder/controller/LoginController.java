package com.ashv.ats.resumebuilder.controller;

import com.ashv.ats.resumebuilder.model.CreateUserRequestModel;
import com.ashv.ats.resumebuilder.model.LoginRequestModel;
import com.ashv.ats.resumebuilder.model.LoginResponseModel;
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

// @CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@Validated
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public void create(@RequestBody @Valid CreateUserRequestModel request) {
        userService.createUser(request);
    }

    @PostMapping("/login")
    public LoginResponseModel login(@RequestBody @Valid LoginRequestModel request) {
        return userService.login(request);
    }
}
  