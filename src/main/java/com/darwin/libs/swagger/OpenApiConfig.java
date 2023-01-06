package com.darwin.libs.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class.
 *
 * @author Team Backend Darwin
 */
@Configuration
public class OpenApiConfig {

  /**
   * Custom OpenAPI.
   *
   * @return Bean object.
   */
  @Bean
  public OpenAPI configurationOpenAPI(@Value("v1") String appVersion) {
    final String securitySchemeName = "Authorization";
    return new OpenAPI()
        .addSecurityItem(new SecurityRequirement()
            .addList(securitySchemeName))
        .components(new Components()
            .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                .name(securitySchemeName)
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")))
        .info(new Info().title("Darwin POS API").version(appVersion));
  }
}
