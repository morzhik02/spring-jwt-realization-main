package com.example.demoauth.models.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "DTO for users search")
public class UserSearchDto {

    @Schema(description = "User id filter", example = "10")
    Long userId;

    @Schema(description = "Username filter", example = "27488")
    String username;
}
