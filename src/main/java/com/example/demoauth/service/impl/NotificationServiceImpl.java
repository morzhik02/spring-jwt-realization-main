package com.example.demoauth.service.impl;

import com.example.demoauth.models.dto.MsgInfoDto;
import com.example.demoauth.models.entity.Notification;
import com.example.demoauth.models.entity.User;
import com.example.demoauth.repository.NotificationRepository;
import com.example.demoauth.service.NotificationService;
import com.example.demoauth.utils.JwtUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class NotificationServiceImpl implements NotificationService {
    NotificationRepository notificationRepository;

    @Override
    @Transactional(readOnly = true)
    public List<MsgInfoDto> getAll() {
        List<Notification> notifications = notificationRepository.findAll();
        List<MsgInfoDto> msgInfoDtos = new ArrayList<>();
        for(Notification notification : notifications){
            String username = JwtUtil.getUsername();
           // if(Objects.equals(notification.getUser().getUsername(), username)) {
                MsgInfoDto msgInfoDto = new MsgInfoDto();
                msgInfoDto.setUsername(notification.getUser().getUsername());
                msgInfoDto.setMessage(notification.getMessage());
                DateTimeFormatter formatterCreatedTime = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
                msgInfoDto.setCreatedTime(notification.getCreatedDate().format(formatterCreatedTime));
                msgInfoDtos.add(msgInfoDto);
           // }
        }

        return msgInfoDtos;
    }
}
