package com.ashv.ats.resumebuilder.controller;

import com.ashv.ats.resumebuilder.entity.UserEntity;
import com.ashv.ats.resumebuilder.model.UpdateUserRequestModel;
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


    @GetMapping("/{userId}")
    public @ResponseBody UserEntity get(@PathVariable("userId")String userId) {
        return userService.get(userId);
    }

    @DeleteMapping("/{userId}")
    public @ResponseBody CreateUserRequestModel get(@PathVariable("userId")String userId) {
        return userService.delete(userId);
    }

    @PatchMapping("/{userId}")
    public @ResponseBody CreateUserRequestModel get(@PathVariable("userId")String userId, @RequestBody UpdateUserRequestModel request) {
        request.getUser().setId(userId);
        return userService.update(request);
    }
}
