package com.example.demoauth.models.entity;

import com.example.demoauth.models.enums.ProgramCode;
import lombok.AccessLevel;
import lombok.*;
import lombok.experimental.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "program_categories")
@FieldDefaults(level = AccessLevel.PRIVATE)
@FieldNameConstants
public class EducationalProgram extends BaseEntity {
    String name;

    @Enumerated(EnumType.STRING)
    ProgramCode code;

}

