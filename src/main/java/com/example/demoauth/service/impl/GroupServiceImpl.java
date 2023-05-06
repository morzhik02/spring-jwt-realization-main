package com.example.demoauth.service.impl;

import com.example.demoauth.models.dto.GroupListInfoDto;
import com.example.demoauth.models.entity.Groups;
import com.example.demoauth.models.entity.User;
import com.example.demoauth.repository.GroupRepository;
import com.example.demoauth.repository.UserRepository;
import com.example.demoauth.service.GroupService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GroupServiceImpl implements GroupService {
    GroupRepository groupRepository;
    UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public GroupListInfoDto findAllByGroup(String group) {
        GroupListInfoDto groupListInfoDto = new GroupListInfoDto();
        Groups groupN = groupRepository.findByName(group);
        groupListInfoDto.setId(groupN.getId());
        groupListInfoDto.setName(groupN.getName());
        User head = userRepository.getByUsername(groupN.getHead().getUsername());
        if (head != null){
            groupListInfoDto.setHeadFullName(head.getLastname() + " "
                    + head.getFirstname() + " "
                    + head.getMidname());
        }
        return groupListInfoDto;
    }

    @Override
    public List<GroupListInfoDto> findAll() {
        List<Groups> groups = groupRepository.findAll();
        List<GroupListInfoDto> groupListInfoDtos = new ArrayList<>();
        for (Groups group : groups) {
            GroupListInfoDto dto = new GroupListInfoDto();
            dto.setId(group.getId());
            dto.setName(group.getName());
            dto.setHeadFullName(group.getHead().getLastname() + " " + group.getHead().getFirstname() + " " + group.getHead().getMidname());
            groupListInfoDtos.add(dto);
        }
        return groupListInfoDtos;
    }
}
