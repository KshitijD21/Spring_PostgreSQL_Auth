package com.auth.authentication.controller;

import com.auth.authentication.model.Users;
import com.auth.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        System.out.println("user in register " + user);
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        System.out.println(user);
        return userService.verify(user);
    }
}
