package com.example.demoauth.repository;

import com.example.demoauth.models.entity.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Groups, Long> {

    Groups findByName(String name);

}