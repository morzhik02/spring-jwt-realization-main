package com.example.demoauth.controllers;

import com.example.demoauth.models.dto.GroupListInfoDto;
import com.example.demoauth.models.entity.Groups;
import com.example.demoauth.service.GroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Tag(name = "Groups API", description = "Methods for work with groups")
@SecurityRequirement(name = "Bearer Authentication")
@CrossOrigin(origins = "*", maxAge = 3600)
public class GroupController {
    GroupService groupService;

    @GetMapping()
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ADMIN')")
    @Operation(summary = "Method to get groups list")
    public ResponseEntity<List<GroupListInfoDto>> findAll() {
        return ResponseEntity.ok(groupService.findAll());
    }


}
