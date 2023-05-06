package com.example.demoauth.service;

import com.example.demoauth.models.dto.NewsCreatedDto;
import com.example.demoauth.models.entity.News;

import java.util.List;

public interface NewsService {
    List<News> getAll();
    void save(NewsCreatedDto newsCreatedDto);
}
