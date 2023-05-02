package com.example.demoauth.controllers;

import com.example.demoauth.models.entity.DocStatus;
import com.example.demoauth.service.DocStatusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/doc_statuses")
@Tag(name = "Doc statuses API", description = "Methods to work with doc statuses")
@SecurityRequirement(name = "Bearer Authentication")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@CrossOrigin(origins = "*", maxAge = 3600)
public class DocStatusController {
    DocStatusService docStatusService;

    @GetMapping()
    @Operation(summary = "Method to get all doc statuses")
    public ResponseEntity<List<DocStatus>> getAllDocStatuses() {
        return ResponseEntity.ok(docStatusService.findAll());
    }
}
