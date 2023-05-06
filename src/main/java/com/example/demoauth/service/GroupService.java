package com.example.demoauth.service;

import com.example.demoauth.models.dto.GroupListInfoDto;

import java.util.List;

public interface GroupService {
    GroupListInfoDto findAllByGroup(String group);
    List<GroupListInfoDto> findAll();
}
