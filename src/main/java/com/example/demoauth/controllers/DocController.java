package com.example.demoauth.controllers;

import com.example.demoauth.models.dto.DocCreateDto;
import com.example.demoauth.models.dto.DocInfoDto;
import com.example.demoauth.models.enums.CategoryCode;
import com.example.demoauth.service.DocService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/doc")
@Tag(name = "Doc API", description = "Methods to work with doc")
@SecurityRequirement(name = "Bearer Authentication")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DocController {

    DocService docService;

    @GetMapping("/{id}")
    @Operation(summary = "Method to get doc with Id")
    public ResponseEntity<DocInfoDto> getDoc(
            @Parameter(description = "Doc id", example = "1", required = true) @PathVariable Long id) {
        return ResponseEntity.ok(docService.findById(id));
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Method to save new post")
    public ResponseEntity<String> save(@RequestParam(value = "category") CategoryCode category,
                @RequestParam(value = "description", required = false) String description) {
            DocCreateDto docCreateDto = DocCreateDto.builder()
                    .category(category)
                    .description(description)
                    .build();
            docService.save(docCreateDto);
            return ResponseEntity.ok("Doc created successfully");
    }
}
