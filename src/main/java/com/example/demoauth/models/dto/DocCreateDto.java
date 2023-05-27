package com.example.demoauth.models.dto;

import com.example.demoauth.models.enums.CategoryCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@ToString
@Schema(description = "DTO for create docs")
public class DocCreateDto {
    @Schema(description = "Doc category code", example = "CERT_STUDY")
    @NotNull(message = "Doc category field required")
    CategoryCode category;

    @Schema(description = "Description", example = "Справка с места учебы")
    @NotBlank(message = "Description field required")
    @Size(min = 20, max = 100, message = "Description of the incident must be at least 20, no more 100 characters")
    String description;
}
