package com.example.demoauth.service.impl;

import com.example.demoauth.exception.DiplomaCoreException;
import com.example.demoauth.models.dto.UserUpdateDto;
import com.example.demoauth.models.entity.User;
import com.example.demoauth.repository.GroupRepository;
import com.example.demoauth.repository.UserRepository;
import com.example.demoauth.service.UserService;
import com.example.demoauth.utils.ApiMessages;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    GroupRepository groupRepository;

    @Override
    public User updateUserProfile(UserUpdateDto userUpdateDto, String username) {
        User user = userRepository.getByUsername(username);
        user.setFirstname(userUpdateDto.getFirstname());
        user.setLastname(userUpdateDto.getLastname());
        user.setMidname(userUpdateDto.getMidname());
        user.setGroup(groupRepository.findByName(userUpdateDto.getGroup()));
        user.setPhoneNumber(userUpdateDto.getPhoneNumber());
        return userRepository.save(user);

    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new DiplomaCoreException(HttpStatus.BAD_REQUEST, ApiMessages.USER_NOT_FOUND,
                        "User with this username not found"));
    }
}
