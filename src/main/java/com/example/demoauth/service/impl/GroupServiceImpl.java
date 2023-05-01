package com.example.demoauth.service.impl;

import com.example.demoauth.models.entity.Group;
import com.example.demoauth.repository.GroupRepository;
import com.example.demoauth.service.GroupService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GroupServiceImpl implements GroupService {

    GroupRepository groupRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Group> findAll() {
        return groupRepository.findAll();
    }
}
