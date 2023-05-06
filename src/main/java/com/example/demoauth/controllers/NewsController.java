package com.example.demoauth.controllers;

import com.example.demoauth.models.dto.DocInfoDto;
import com.example.demoauth.models.dto.DocSearchDto;
import com.example.demoauth.models.dto.NewsCreatedDto;
import com.example.demoauth.models.entity.News;
import com.example.demoauth.service.NewsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/news")
@Tag(name = "News API", description = "Methods to work with news")
@SecurityRequirement(name = "Bearer Authentication")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@CrossOrigin(origins = "*", maxAge = 3600)
public class NewsController {
    NewsService newsService;

    @GetMapping
    @Operation(summary = "Method to get all news")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<News>> getAllDocs() {
        return ResponseEntity.ok(newsService.getAll());
    }

    @PostMapping
    @Operation(summary = "Method to save new news")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<String> save(@Valid @RequestBody NewsCreatedDto newsCreatedDto){
        newsService.save(newsCreatedDto);
        return ResponseEntity.ok("News created successfully");
    }
}
