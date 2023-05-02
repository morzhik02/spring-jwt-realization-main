package com.example.demoauth.service;

public interface EmailService {
    void sendEmail(String to, String subject, String message);
}
