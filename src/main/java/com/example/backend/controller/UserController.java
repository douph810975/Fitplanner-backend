package com.example.backend.controller;

import com.example.backend.entity.User;
//import com.example.backend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
//    @GetMapping("/hello")
//    public String hello(){
//        return "hello, world";
//    }
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/login")
//    public String loginUser(@RequestParam String username, @RequestParam String password) {
//        logger.info("Received POST request for /auth/login");
//        Optional<User> user = userService.loginUser(username, password);
//        return user.isPresent() ? "Login successful" : "Invalid username or password";
//    }
//    @PostMapping("/register")
//    public String registerUser(@RequestParam String username, @RequestParam String password) {
//        try {
//            userService.registerUser(username, password);
//            return "User registered successfully";
//        } catch (Exception e) {
//            return e.getMessage();
//        }
//    }

}
