package com.example.demoauth.controllers;

import com.example.demoauth.models.entity.Greeting;
import com.example.demoauth.models.entity.NotificationMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "MSG API", description = "Methods to work with msg")
@SecurityRequirement(name = "Bearer Authentication")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@CrossOrigin(origins = "*", maxAge = 3600)
public class GreetingController {

    @MessageMapping("/msg")
    @SendTo("/topic/greetings")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @Operation(summary = "Method to get msg")
    public Greeting greet(NotificationMessage message){
        return new Greeting(HtmlUtils.htmlEscape(message.getName()));
    }

}
