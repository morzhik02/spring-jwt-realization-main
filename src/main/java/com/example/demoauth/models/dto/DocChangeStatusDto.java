package com.example.demoauth.models.dto;

import com.example.demoauth.models.enums.StatusCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "DTO for change doc status")
public class DocChangeStatusDto {
    @Schema(description = "Doc id", example = "1")
    Long id;

    @Schema(description = "Doc status code", example = "CLOSED")
    StatusCode statusCode;
}
