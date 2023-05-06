package com.example.demoauth.models.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "DTO for groups list info")
public class GroupListInfoDto {
    @Schema(description = "Group id", example = "1")
    Long id;

    @Schema(description = "Group name", example = "ITIS-1917")
    String name;

    @Schema(description = "Group head FullName", example = "Абдуллаева Асель Сейдулаевна")
    String headFullName;
}
