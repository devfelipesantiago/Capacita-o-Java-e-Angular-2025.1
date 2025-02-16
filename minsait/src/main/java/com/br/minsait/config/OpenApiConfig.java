package com.br.minsait.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Contact API")
            .description("API for managing contacts")
            .contact(new Contact()
                .name("Felipe")
                .email("devFelipeSantiago@gmail.com")
                .url("https://github.com/devfelipesantiago"))
            .version("v1"));
  }
}
