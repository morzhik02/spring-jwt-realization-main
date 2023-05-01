package com.example.demoauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DemoauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoauthApplication.class, args);
	}

}
