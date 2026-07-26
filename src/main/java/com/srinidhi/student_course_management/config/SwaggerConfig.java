package com.srinidhi.student_course_management.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Student Course Management System API")
                        .version("1.0")
                        .description("REST APIs for managing students, courses and course enrollments.")
                        .contact(
                                new Contact()
                                        .name("Namrutha Srinidhi T")
                                        .email("your-email@example.com")
                        ));
    }
}