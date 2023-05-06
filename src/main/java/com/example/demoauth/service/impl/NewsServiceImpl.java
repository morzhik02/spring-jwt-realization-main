package com.example.demoauth.service.impl;

import com.example.demoauth.models.dto.DocCreateDto;
import com.example.demoauth.models.dto.NewsCreatedDto;
import com.example.demoauth.models.entity.Doc;
import com.example.demoauth.models.entity.News;
import com.example.demoauth.models.enums.StatusCode;
import com.example.demoauth.repository.NewsRepository;
import com.example.demoauth.service.NewsService;
import com.example.demoauth.utils.JwtUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class NewsServiceImpl implements NewsService {
    NewsRepository newsRepository;

    @Override
    @Transactional
    public void save(NewsCreatedDto newsCreateDto) {
        try {
            News news = new News();
            news.setTheme(newsCreateDto.getTheme());
            news.setText(newsCreateDto.getText());
            news.setCreatedDate(LocalDateTime.now());
            newsRepository.save(news);
        } catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    public List<News> getAll() {
        return newsRepository.findAll();
    }
}
