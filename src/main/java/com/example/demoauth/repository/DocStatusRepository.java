package com.example.demoauth.repository;

import com.example.demoauth.models.entity.DocStatus;
import com.example.demoauth.models.enums.StatusCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocStatusRepository extends JpaRepository<DocStatus, Long> {
    DocStatus findByCode(StatusCode code);
}
