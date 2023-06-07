package com.example.demoauth.controllers;

import com.example.demoauth.models.dto.MsgInfoDto;
import com.example.demoauth.models.entity.News;
import com.example.demoauth.models.entity.Notification;
import com.example.demoauth.service.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/msg")
@Tag(name = "MESSAGE API", description = "Methods to work with msgs")
@SecurityRequirement(name = "Bearer Authentication")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@CrossOrigin(origins = "*", maxAge = 3600)
public class NotificationController {
    NotificationService notificationService;

    @GetMapping
    @Operation(summary = "Method to get all notifications")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<MsgInfoDto>> getAllNotifications() {
        return ResponseEntity.ok(notificationService.getAll());
    }

}
