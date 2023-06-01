package com.example.demoauth.models.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
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

    @Schema(description = "Doc description", example = "please help")
    String description;

    @Schema(description = "Doc user fullname", example = "Izteleu Marzhan Assylkhankyzy")
    String user;

    @Schema(description = "Doc user firstName", example = "Marzhan")
    String firstname;

    @Schema(description = "Doc user lastName", example = "Izteleu")
    String lastname;

    @Schema(description = "Doc user midName", example = "Assylkhankyzy")
    String midname;

    @Schema(description = "Doc manager fullname", example = "Izteleu Marzhan Assylkhankyzy")
    String manager;

    @Schema(description = "Doc manager fullname", example = "Izteleu Marzhan Assylkhankyzy")
    String managerLogin;

    @Schema(description = "Doc student iin", example = "020421600130")
    String studIIN;

    @Schema(description = "Doc student faculty", example = "Факультет цифровых трансформаций")
    String faculty;

    @Schema(description = "Doc student educational program", example = "Информационные системы")
    String program;

    @Schema(description = "Doc to work date", example = "29-03-2022 16:43")
    LocalDateTime workDate;

    @Schema(description = "Doc's closed date", example = "29-03-2022 16:56")
    LocalDateTime closedDate;

    @Schema(description = "Doc's reject date", example = "29-03-2022 16:56")
    LocalDateTime rejectedDate;

    @Schema(description = "Doc's cancel date", example = "29-03-2022 16:56")
    LocalDateTime canceledDate;

    @Schema(description = "Doc's created date", example = "29-03-2022 16:56")
    LocalDateTime createdAt;

    @Schema(description = "Doc's updated date", example = "29-03-2022 16:56")
    LocalDateTime updatedAt;

    @Schema(description = "User year of admission", example = "2019")
    String yearAdm;

    @Schema(description = "User grant", example = "Государственный")
    String studGrant;

    @Schema(description = "User year of graduation", example = "2023")
    String yearGrad;

    @Schema(description = "User id", example = "2023")
    String userId;

    @Schema(description = "User course", example = "4")
    String cource;

    @Schema(description = "User educationType", example = "Очная")
    String educationType;
}

