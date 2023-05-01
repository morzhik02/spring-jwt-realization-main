package com.example.demoauth.models.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "heads")
@FieldNameConstants
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Group extends BaseEntity {

    String name;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<User> users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "head_id")
    User head;

}
