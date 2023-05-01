package com.example.demoauth.service.impl;

import com.example.demoauth.models.entity.DocCategory;
import com.example.demoauth.repository.DocCategoryRepository;
import com.example.demoauth.service.DocCategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DocCategoryServiceImpl implements DocCategoryService {
    DocCategoryRepository docCategoryRepository;

    @Override
    public List<DocCategory> findAll() {
        return docCategoryRepository.findAll();
    }
}
