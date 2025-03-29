package org.dazi.tliasjava21.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
  @Bean
  public OpenAPI openAPI() {
    System.out.println("Swagger 接口文档 http://localhost:8080/swagger-ui.html");
    return new OpenAPI()
        .info(new Info()
            .title("API 文档")
            .description("Spring Boot 3.4.4 集成 Swagger 示例")
            .version("v1.0"));
  }
}
