package com.example.demoauth.models.dto;

import com.example.demoauth.models.enums.CategoryCode;
import com.example.demoauth.models.enums.StatusCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "DTO for docs search")
public class DocSearchDto {

    @Schema(description = "Doc category filter", example = "CERT_STUDY")
    CategoryCode category;

    @Schema(description = "Doc status filter", example = "CANCELED")
    StatusCode status;

    @Schema(description = "Doc manager filter", example = "o.kim")
    String managerLogin;

    @Schema(description = "Doc manager filter", example = "o.kim")
    List<StatusCode> statuses;

    @Schema(description = "Doc id filter", example = "39")
    Long docId;

}
