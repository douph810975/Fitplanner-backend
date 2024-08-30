package com.example.backend.service;

//import org.apache.commons.mail.EmailException;
//import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail2.jakarta.HtmlEmail;
import org.apache.commons.mail2.core.EmailException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    public void sendVerificationEmail(String toEmail, String verificationCode) throws EmailException {
        HtmlEmail email = new HtmlEmail();
        email.setHostName(host);
        email.setSmtpPort(port);
        email.setAuthentication(username, password);
        email.setSSLOnConnect(true); // 确保启用了 SSL
        email.setStartTLSEnabled(true);
        email.setFrom(username);
        email.setSubject("Email Verification Code");

        String message = "<html><body><h3>Your verification code is: " + verificationCode + "</h3></body></html>";
        email.setHtmlMsg(message);

        email.addTo(toEmail);
        email.send();
    }
}
