package com.example.demoauth.service;

import com.example.demoauth.models.entity.DocCategory;
import com.example.demoauth.models.entity.DocStatus;

import java.util.List;

public interface DocCategoryService {
    List<DocCategory> findAll();
}
