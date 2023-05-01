package com.example.demoauth.controllers;

import com.example.demoauth.models.entity.DocCategory;
import com.example.demoauth.repository.DocCategoryRepository;
import com.example.demoauth.service.DocCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/doc_categories")
@Tag(name = "Doc categories API", description = "Methods to work with doc categories")
@SecurityRequirement(name = "Bearer Authentication")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DocCategoryController {

    DocCategoryService docCategoryService;

    @GetMapping()
    @Operation(summary = "Method to get all doc categories")
    public ResponseEntity<List<DocCategory>> getAllPostCategories() {
        return ResponseEntity.ok(docCategoryService.findAll());
    }
}
