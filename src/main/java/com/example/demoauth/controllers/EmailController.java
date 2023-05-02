package com.example.demoauth.controllers;

import com.example.demoauth.pojo.EmailMessageResponse;
import com.example.demoauth.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Tag(name = "EmailSender API", description = "Methods for work with email sender")
@SecurityRequirement(name = "Bearer Authentication")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmailController {

    EmailService emailService;

    @PostMapping("/send")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @Operation(summary = "Method to send email")
    public ResponseEntity sendEmail(@RequestBody EmailMessageResponse emailMessageResponse){
        emailService.sendEmail(emailMessageResponse.getTo(), emailMessageResponse.getSubject(), emailMessageResponse.getMessage());
        return ResponseEntity.ok("Success mail send to " + emailMessageResponse.getTo() + ". Send time:" + LocalDate.now());
    }
}
