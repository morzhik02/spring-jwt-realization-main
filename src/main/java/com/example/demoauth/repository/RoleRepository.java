package com.example.demoauth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoauth.models.enums.ERole;
import com.example.demoauth.models.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByName(ERole name);
}
