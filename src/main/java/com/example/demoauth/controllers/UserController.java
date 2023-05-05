package com.example.demoauth.controllers;

import com.example.demoauth.models.dto.UserMeProfileDto;
import com.example.demoauth.models.dto.UserUpdateDto;
import com.example.demoauth.models.entity.User;
import com.example.demoauth.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
@Tag(name = "Users API", description = "Methods for work with users")
@SecurityRequirement(name = "Bearer Authentication")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    UserService userService;

    @GetMapping("/profile")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @Operation(summary = "Method to get user profile")
    public ResponseEntity<User> getUserInfo(@RequestParam String username) {
        return ResponseEntity.ok(userService.findByUsername(username));
    }

//    @GetMapping("/me")
//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//    @Operation(summary = "Method to get my user profile")
//    public ResponseEntity<Optional<User>> getMyUserInfo() {
//        return ResponseEntity.ok(userService.myUserProfile());
//    }

    @GetMapping("/me")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @Operation(summary = "Method to get my user profile")
    public ResponseEntity<UserMeProfileDto> getMyUserInfo() {
        return ResponseEntity.ok(userService.meProfile());
    }

    @PutMapping("/profile")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @Operation(summary = "Method to update user profile")
    public ResponseEntity<String> updateUserProfile(@Valid @RequestBody UserUpdateDto userUpdateDto, @RequestParam String username) {
        userService.updateUserProfile(userUpdateDto, username);
        return ResponseEntity.ok("User profile updated successfully");
    }
}
