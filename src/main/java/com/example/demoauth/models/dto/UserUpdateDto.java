package com.example.demoauth.models.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Dto for user update")
public class UserUpdateDto {

    @Schema(description = "User firstname", example = "Marzhan")
    @Size(max = 50, message = "User firstname must be no more 50 characters")
    String firstname;

    @Schema(description = "User lastname", example = "Izteleu")
    @Size(max = 50, message = "User lastname must be no more 50 characters")
    String lastname;

    @Schema(description = "User midname", example = "Assylkhankyzy")
    String midname;

    @Schema(description = "User phone number", example = "+77005553535")
    @Size(min = 12, max = 12, message = "Phone Number Should Be Valid")
    String phoneNumber;

    @Schema(description = "User group", example = "ITIS-1917")
    String group;

}
