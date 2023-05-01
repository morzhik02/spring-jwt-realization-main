package com.example.demoauth.models.entity;

import com.example.demoauth.models.enums.StatusCode;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "doc_statuses")
@FieldDefaults(level = AccessLevel.PRIVATE)
@FieldNameConstants
public class DocStatus extends BaseEntity {

    String name;

    @Enumerated(EnumType.STRING)
    StatusCode code;
}
