package com.example.demoauth.configs;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Document Management System service API")
                        .description("Izteleu Marzhan, Tolshina Victoria Diploma Work")
                        .version("v1.0.0").license(new License().name("Apache 2.0")
                                .url("http://springdoc.org")).contact(new Contact().name("Izteleu Marzhan")
                                .email("27488@iitu.edu.kz")));
    }
}
