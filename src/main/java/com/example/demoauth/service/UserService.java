package com.example.demoauth.service;

import com.example.demoauth.models.dto.UserMeProfileDto;
import com.example.demoauth.models.dto.UserUpdateDto;
import com.example.demoauth.models.entity.User;

import java.util.Optional;

public interface UserService {

    User updateUserProfile(UserUpdateDto userUpdateDto, String username);
    Optional<User> myUserProfile();
    UserMeProfileDto meProfile();
    UserMeProfileDto findByUsername(String username);
    User findUserName(String username);
}
