package com.example.demoauth.models.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "groups")
@FieldNameConstants
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Groups extends BaseEntity{
    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "head_id")
    User head;
}
