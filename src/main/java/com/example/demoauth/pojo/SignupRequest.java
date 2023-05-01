package com.example.demoauth.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Dto for user registration")
public class SignupRequest {
	
	private String username;
	private String email;
	private Set<String> roles;
	private String password;
	
}
