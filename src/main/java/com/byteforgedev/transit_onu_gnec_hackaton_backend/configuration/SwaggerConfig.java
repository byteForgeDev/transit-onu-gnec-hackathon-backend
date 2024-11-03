package com.byteforgedev.transit_onu_gnec_hackaton_backend.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "TRANSIT ONU GNEC API",
                description = "Our app provides a concise method for users and transit companies to have a cleaner view of possible routes.",
                version = "1.0.0",
                contact = @Contact(
                        name = "byteForgeDev",
                        url = "https://github.com/byteForgeDev"
                )
        ),
        servers = {
                @Server(
                        description = "PROD SERVER",
                        url = "http://${IP_PRODUCTION}:8080" // Placeholder
                ),
                @Server(
                        description = "DEV SERVER",
                        url = "http://localhost:8080"
                )  
        },
        security = @SecurityRequirement(
                name = "Security Token"
        )
)
@SecurityScheme(
        name = "Security Token",
        description = "Access Token For My API",
        type = SecuritySchemeType.HTTP,
        paramName = HttpHeaders.AUTHORIZATION,
        in = SecuritySchemeIn.HEADER,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class SwaggerConfig {

}
