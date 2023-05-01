package com.example.demoauth.repository;

import com.example.demoauth.models.entity.DocCategory;
import com.example.demoauth.models.enums.CategoryCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocCategoryRepository extends JpaRepository<DocCategory, Long> {
    DocCategory findByCode(CategoryCode code);
}
