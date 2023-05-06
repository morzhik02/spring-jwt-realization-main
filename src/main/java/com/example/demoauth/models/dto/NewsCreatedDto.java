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
@Schema(description = "DTO for create news")
public class NewsCreatedDto {
    @Schema(description = "News theme", example = "Свободное посещение")
    @NotNull(message = "Theme field required")
    String theme;

    @Schema(description = "News text", example = "C 02.02.2023 подать заявку на свободное посещение можно только оффлайн, в 304 кабинете")
    @NotBlank(message = "Text field required")
    String text;
}
