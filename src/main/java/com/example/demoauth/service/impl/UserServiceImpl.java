package com.example.demoauth.service.impl;

import com.example.demoauth.exception.DiplomaCoreException;
import com.example.demoauth.models.dto.UserMeProfileDto;
import com.example.demoauth.models.dto.UserUpdateDto;
import com.example.demoauth.models.entity.User;
import com.example.demoauth.repository.GroupRepository;
import com.example.demoauth.repository.UserRepository;
import com.example.demoauth.service.UserService;
import com.example.demoauth.utils.ApiMessages;
import com.example.demoauth.utils.JwtUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
    public Optional<User> myUserProfile() {
        return userRepository.findByUsername(JwtUtil.getUsername());
    }

    @Override
    @Transactional(readOnly = true)
    public UserMeProfileDto meProfile() {
        UserMeProfileDto userMe = new UserMeProfileDto();
        String username = JwtUtil.getUsername();
        User user = userRepository.findByUsername(username).get();
        userMe.setFirstname(user.getFirstname());
        userMe.setLastname(user.getLastname());
        userMe.setMidname(user.getMidname());
        userMe.setPhoneNumber(user.getPhoneNumber());
        userMe.setEmail(user.getEmail());
        userMe.setGroup(user.getGroup().getName());
        User head = user.getHead();
        if (head != null){
            userMe.setHeadFullName(head.getLastname() + " "
                                + head.getFirstname() + " "
                                + head.getMidname());
        }
        userMe.setRoles(user.getRoles());
        return userMe;
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new DiplomaCoreException(HttpStatus.BAD_REQUEST, ApiMessages.USER_NOT_FOUND,
                        "User with this username not found"));
    }
}
