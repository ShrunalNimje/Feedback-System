package com.mymood.feedbacksystem.Feedback.System.OpenAPI;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfiguration {

	@Bean
	public OpenAPI customOpenAPI() {
		
		return new OpenAPI()
				.info(new Info()
						.title("Student Feedback System")
						.version("1.0")
						.description("A RESTful API for managing students feedbacks and user authentication."))
                
                .servers(Arrays.asList(new Server().url("http://localhost:8080").description("local"),
                		new Server().url("http://localhost:8082").description("live")))
                
                .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                
                .components(new Components()
                    .addSecuritySchemes("Bearer Authentication",
                        new SecurityScheme()
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT")));
	}
}
