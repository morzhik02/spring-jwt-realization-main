package com.example.demoauth.models.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldNameConstants
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "username"),
				@UniqueConstraint(columnNames = "email")
		})
public class User extends BaseEntity{
	
	String username;
	String email;
	String password;
	String firstname;
	String lastname;
	String midname;
	String phoneNumber;
	String stud_iin;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "faculty_id")
	UserFaculty faculty;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "program_id")
	EducationalProgram program;

	String admissionYear;
	String graduationYear;
	String studGrant;
	String studId;
	String course;
	String educationType;
	String position;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_id")
	Groups group;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
}
