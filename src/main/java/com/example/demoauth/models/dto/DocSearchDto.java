package com.example.demoauth.models.dto;

import com.example.demoauth.models.enums.CategoryCode;
import com.example.demoauth.models.enums.StatusCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "DTO for docs search")
public class DocSearchDto {
//    @Schema(description = "Docs incident date from filter", type = "string", pattern = "dd-MM-yyyy", example = "25-03-2022")
//    @DateTimeFormat(pattern = "dd-MM-yyyy")
//    Date dateFrom;
//
//    @Schema(description = "Docs incident date to filter", type = "string", pattern = "dd-MM-yyyy", example = "25-04-2022")
//    @DateTimeFormat(pattern = "dd-MM-yyyy")
//    Date dateTo;

    @Schema(description = "Doc category filter", example = "CERT_STUDY")
    CategoryCode category;

    @Schema(description = "Doc status filter", example = "CANCELED")
    StatusCode status;

    @Schema(description = "Doc manager filter", example = "o.kim")
    String managerLogin;

//    @Schema(description = "Query search for doc number")
//    String query;
}
