package com.example.demoauth.repository;

import com.example.demoauth.models.entity.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Groups, Long> {

    Groups findByName(String name);

    //List<Groups> findAllByGroupName(String GroupName);
}