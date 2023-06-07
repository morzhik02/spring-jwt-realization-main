package com.example.demoauth.service;

import com.example.demoauth.models.entity.News;
import com.example.demoauth.models.entity.Notification;

import java.util.List;

public interface NotificationService {
    List<Notification> getAll();
}
