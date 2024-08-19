package com.example.backend.controller;

import com.example.backend.entity.User;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password) {
        Optional<User> user = userService.loginUser(username, password);
        return user.isPresent() ? "Login successful" : "Invalid username or password";
    }
    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        try {
            userService.registerUser(username, password);
            return "User registered successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
