package com.example.demoauth.models.dto;

import com.example.demoauth.models.entity.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Size;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "DTO for user me profile info")
public class UserMeProfileDto {
    @Schema(description = "User firstname", example = "Marzhan")
    @Size(max = 50, message = "User firstname must be no more 50 characters")
    String firstname;

    @Schema(description = "User lastname", example = "Izteleu")
    @Size(max = 50, message = "User lastname must be no more 50 characters")
    String lastname;

    @Schema(description = "User midname", example = "Assylkhankyzy")
    String midname;

    @Schema(description = "User fullname", example = "Izteleu Marzhan Assylkhankyzy")
    String user;

    @Schema(description = "User phone number", example = "+77005553535")
    @Size(min = 12, max = 12, message = "Phone Number Should Be Valid")
    String phoneNumber;

    @Schema(description = "User head", example = "Абдуллаева Асель Сейдулаевна")
    String headFullName;

    @Schema(description = "User group", example = "ITIS-1917")
    String group;

    @Schema(description = "User email", example = "27488@iitu.edu.kz")
    String email;

    @Schema(description = "User stud IIN", example = "020421600130")
    String studIIN;

    @Schema(description = "User faculty", example = "Факультет цифровых трансформаций")
    String faculty;

    @Schema(description = "User educational program", example = "Информационные системы")
    String program;

    @Schema(description = "User roles", example = "ITIS-1917")
    Set<Role> roles;

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
