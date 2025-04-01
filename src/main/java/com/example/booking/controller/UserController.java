package com.example.booking.controller;

import com.example.booking.models.User;
import com.example.booking.response.LoginResponse;
import com.example.booking.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.booking.requests.LoginRequest;
import com.example.booking.service.UserService;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTService jwtService;

    @PostMapping("/auth/signup")
    public ResponseEntity<User> signupUser(@RequestBody User user)
    {
        User signup_user = userService.addUser(user);

        return ResponseEntity.ok(signup_user);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest)
    {
        User user = userService.loginUser(loginRequest);

        String jwtToken = jwtService.generateToken(new HashMap<>(), user);

        LoginResponse loginResponse = new LoginResponse();

        loginResponse.setToken(jwtToken);
        loginResponse.setToknExpirationTime(jwtService.getJwtExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> users = userService.getAllUsers();

        return ResponseEntity.ok(users);
    }
}
