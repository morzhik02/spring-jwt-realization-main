package com.example.demoauth.repository;

import com.example.demoauth.models.entity.Group;
import com.example.demoauth.models.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByName(String name);
}
