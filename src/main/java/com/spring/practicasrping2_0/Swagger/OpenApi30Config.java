package com.spring.practicasrping2_0.Swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Si hemos intentado lanzar alguna consulta desde Swagger UI nos habremos dado cuenta de que sólo funcionan los endpoints que no están securizados y no tenemos posibilidad de añadir las cabeceras.
 *
 * Esto sucede porque todavía no hemos configurado Swagger. Hasta ahora hemos utilizado la configuración por defecto pero necesitamos poder añadir el token cuando vamos a realizar una request.
 *
 * Para ello crearemos una clase nueva OpenApi30Config que definirá nuestro ApiKey para incluir JWT como autorización en la cabecera y entonces configuraremos el JWT SecurityContext con el global AuthorizationScope.
 *
 * Y luego, configuramos nuestro bean API Docket para incluir información de API, contextos de seguridad y esquemas de seguridad
 */

@Configuration
public class OpenApi30Config {

    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "My REST API",
                "Ejemplo Spring Rest Api con Spring Security JWT",
                "1.0",
                "Terms of service",
                new Contact("Jose", "www.google.com", "email_de_contacto@gmail.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }
}