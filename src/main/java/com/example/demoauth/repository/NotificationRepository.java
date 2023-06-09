package com.example.demoauth.repository;

import com.example.demoauth.models.entity.Doc;
import com.example.demoauth.models.entity.News;
import com.example.demoauth.models.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository  extends JpaRepository<Notification, Long>, JpaSpecificationExecutor<Notification> {

}
