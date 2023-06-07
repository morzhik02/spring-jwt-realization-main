package com.example.demoauth.models.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "DTO for docs info")
public class MsgInfoDto {

    String username;

    String message;

    @Schema(description = "Doc's createdTime date", example = "29.05.2023 16:43")
    String createdTime;
}
