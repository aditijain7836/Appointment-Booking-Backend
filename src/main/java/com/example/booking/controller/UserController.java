package com.example.booking.controller;

import com.example.booking.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.booking.requests.LoginRequest;
import com.example.booking.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login()
    {
        return "login page";
    }

    @GetMapping("/home")
    public String home()
    {
        return "home";
    }

    @PostMapping("/register")
    public String register(@RequestBody User user)
    {
        userService.addUser(user);
        return "Success";
    }

    @PostMapping("/loginUser")
    public Boolean loginUser(@RequestBody LoginRequest loginRequest)
    {
        return userService.loginUser(loginRequest);
    }
}
