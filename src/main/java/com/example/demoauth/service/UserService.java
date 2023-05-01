package com.example.demoauth.service;

import com.example.demoauth.models.dto.UserUpdateDto;
import com.example.demoauth.models.entity.User;

public interface UserService {

    User updateUserProfile(UserUpdateDto userUpdateDto, String username);

    User findByUsername(String username);
}
