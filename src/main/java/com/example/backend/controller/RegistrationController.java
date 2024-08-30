package com.example.backend.controller;

import com.example.backend.service.EmailService;
//import org.apache.commons.mail.EmailException;
import org.apache.commons.mail2.core.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api/users")
public class RegistrationController {
    @Autowired
    private EmailService emailService;

    public static String Vcode;
    @PostMapping("/sendVerificationCode")
    public String sendVerification(@RequestBody Map<String, String> payload) {
        System.out.println("Received register info: " + payload);
        // 生成6位随机验证码
        String verificationCode = generateVerificationCode();
        Vcode = verificationCode;
        String mail = payload.get("email");
        // 将验证码发送到用户的邮箱
        try {
            emailService.sendVerificationEmail(mail, verificationCode);
        } catch (EmailException e) {
            e.printStackTrace();
            return "Error sending email";
        }

        // 存储用户信息和验证码到数据库（省略数据库操作）

        return "Verification email sent";
    }

    private String generateVerificationCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000); // 生成6位数的验证码
        return String.valueOf(code);
    }
}
