//package com.example.backend.service;
//
//import com.example.backend.entity.User;
////import com.example.backend.repository.UserRepository;
//import com.example.backend.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    // 注册新用户
//    public User registerUser(String username, String password) {
//        // 检查用户名是否已存在
//        if (userRepository.findByUsername(username).isPresent()) {
//            throw new RuntimeException("Username already exists");
//        }
//        // 创建新用户并保存
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(passwordEncoder.encode(password));
//        return userRepository.save(user);
//    }

    // 用户登录
//    public Optional<User> loginUser(String username, String password) {
//        // 通过用户名查找用户
//        Optional<User> user = userRepository.findByUsername(username);
//
//        // 验证密码是否正确
//        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
//            return user;
//        }
//
//        // 如果用户名或密码不匹配，返回空的Optional
//        return Optional.empty();
//    }
//    public Optional<User> loginUser(String username, String password) {
//        // 通过用户名查找用户
//        Optional<User> user = userRepository.findByUsername(username);
//
//        // 验证密码是否正确
//        if (user.isPresent() && password.equals(user.get().getPassword())) {
//            return user;
//        }
//
//        // 如果用户名或密码不匹配，返回空的Optional
//        return Optional.empty();
//    }
//
//}
