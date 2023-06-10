package com.example.demoauth.service;

import com.example.demoauth.models.dto.GroupListInfoDto;

import java.util.List;

public interface GroupService {
    List<GroupListInfoDto> findAll();
}
