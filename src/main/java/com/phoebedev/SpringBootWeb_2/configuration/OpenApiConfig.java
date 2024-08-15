package com.phoebedev.SpringBootWeb_2.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("!prod") // build tất cả môi trường tru product
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${openapi.service.title}") String title,
                                 @Value("${openapi.service.version}") String version,
                                 @Value("${openapi.service.server}") String serverUrl,
                                 @Value("${openapi.service.api-docs}") String serverName)
    {
        return new OpenAPI().info(new Info()
                                .title(title)
                                .version(version)
                                .license(new License().name("Api License 1.0.0"). url("http://domain.vn/license.3.0" +
                                        ".0")))
                            .servers(List.of(new Server().url(serverUrl).description(serverName)));
//                            .components
//                                    (new Components()
//                                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
//                                            .type(SecurityScheme.Type.HTTP)
//                                            .scheme("bearer")
//                                            .bearerFormat("JWT")
//                                    ))
//                .security(List.of(new SecurityRequirement().addList("bearerAuth")));

    }

    // thiết lập url tích hợp microservice
    @Bean
    public GroupedOpenApi groupedOpenApi() {
        return  GroupedOpenApi.builder()
                .group("api-service-1")
                .packagesToScan("com.phoebedev.SpringBootWeb_2.controller") // scan all bean controller
                .build();
    }
}
