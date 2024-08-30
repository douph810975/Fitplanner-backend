package com.example.backend.controller;

import com.example.backend.entity.User;
//import com.example.backend.service.UserService;
import com.example.backend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

//    @PostMapping("/login")
//    public String loginUser(@RequestParam String username, @RequestParam String password) {
//        //logger.info("Received POST request for /auth/login");
//        Optional<User> user = userService.loginUser(username, password);
//        return user.isPresent() ? "Login successful" : "Invalid username or password";
//    }
    @PostMapping("/login")
    public String loginUser(@RequestBody Map<String, String> payload) {
        System.out.println("Received payload: " + payload);
        String username = payload.get("username");
        String password = payload.get("password");

        Optional<User> user = userService.loginUser(username, password);
//        if(user.isPresent()) {
//            System.out.println("Login successful");
//        }
        return user.isPresent() ? "Login successful" : "Invalid username or password";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody Map<String, String> payload) {
        System.out.println("Received payload: " + payload);
        String username = payload.get("username");
        String password = payload.get("password");
        String email = payload.get("email");
        String verificationCode = payload.get("verificationCode");
        try {
            userService.registerUser(username, password,email,verificationCode);
            return "User registered successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
