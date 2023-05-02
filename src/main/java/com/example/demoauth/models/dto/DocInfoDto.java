package com.example.demoauth.models.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @Schema(description = "Doc manager fullname", example = "Izteleu Marzhan Assylkhankyzy")
    String manager;

    @Schema(description = "Doc to work date", example = "29-03-2022 16:43")
    LocalDateTime workDate;

    @Schema(description = "Doc's closed date", example = "29-03-2022 16:56")
    LocalDateTime closedDate;

}

