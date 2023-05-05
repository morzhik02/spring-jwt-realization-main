package com.example.demoauth.models.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "DTO for docs info")
public class DocInfoDto {

    @Schema(description = "Doc id", example = "1")
    Long id;

    @Schema(description = "Doc status", example = "В работе")
    String status;

    @Schema(description = "Doc category", example = "Справка")
    String category;

    @Schema(description = "Doc description", example = "please help ")
    String description;

    @Schema(description = "Doc user fullname", example = "Izteleu Marzhan Assylkhankyzy")
    String user;

    @Schema(description = "Doc user firstName", example = "Marzhan")
    String studFirstName;

    @Schema(description = "Doc user lastName", example = "Izteleu")
    String studLastName;

    @Schema(description = "Doc user midName", example = "Assylkhankyzy")
    String studMidName;

    @Schema(description = "Doc manager fullname", example = "Izteleu Marzhan Assylkhankyzy")
    String manager;

    @Schema(description = "Doc student iin", example = "020421600130")
    String studentIIN;

    @Schema(description = "Doc student faculty", example = "Факультет цифровых трансформаций")
    String faculty;

    @Schema(description = "Doc student educational program", example = "Информационные системы")
    String program;

    @Schema(description = "Doc to work date", example = "29-03-2022 16:43")
    LocalDateTime workDate;

    @Schema(description = "Doc's closed date", example = "29-03-2022 16:56")
    LocalDateTime closedDate;

}

