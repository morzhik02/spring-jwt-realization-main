package com.example.demoauth.controllers;

import com.example.demoauth.models.dto.DocChangeStatusDto;
import com.example.demoauth.models.dto.DocCreateDto;
import com.example.demoauth.models.dto.DocInfoDto;
import com.example.demoauth.models.dto.DocSearchDto;
import com.example.demoauth.service.DocService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/doc")
@Tag(name = "Doc API", description = "Methods to work with doc")
@SecurityRequirement(name = "Bearer Authentication")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@CrossOrigin(origins = "*", maxAge = 3600)
public class DocController {

    DocService docService;

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @Operation(summary = "Method to get doc with Id")
    public ResponseEntity<DocInfoDto> getDoc(
            @Parameter(description = "Doc id", example = "1", required = true) @PathVariable Long id) {
        return ResponseEntity.ok(docService.findById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @Operation(summary = "Method to save new doc")
    public ResponseEntity<String> save(@RequestBody DocCreateDto docCreateDtoI) {
        DocCreateDto docCreateDto = DocCreateDto.builder()
                    .category(docCreateDtoI.getCategory())
                    .description(docCreateDtoI.getDescription())
                    .build();
        docService.save(docCreateDto);
        return ResponseEntity.ok("Doc created successfully");
    }

    @PatchMapping("/status")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @Operation(summary = "Method to change status of docs")
    public ResponseEntity<String> changeStatusOfDoc(@RequestBody DocChangeStatusDto docChangeStatusDto) {
        docService.changeStatus(docChangeStatusDto);
        return ResponseEntity.ok("Doc status changed successfully");
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @Operation(summary = "Method to get all doc")
    public ResponseEntity<List<DocInfoDto>> getAllDocs(
            @ParameterObject DocSearchDto docSearchDto) {
        return ResponseEntity.ok(docService.findAllByRole(docSearchDto));
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @Operation(summary = "Method to get all doc")
    public ResponseEntity<List<DocInfoDto>> getAllDoc(
            @ParameterObject DocSearchDto docSearchDto) {
        return ResponseEntity.ok(docService.findAll(docSearchDto));
    }
}
