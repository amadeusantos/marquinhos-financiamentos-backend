package com.marquinhos.financiamentos.backend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Marquinhos Financiamentos",
                version = "1.0",
                license = @License(name = "GPL-3.0", url = "https://www.gnu.org/licenses/gpl-3.0.html#license-text")
        ),
        servers = {
                @Server(description = "Local ENV", url = "http://localhost:8080"),
                @Server(description = "Server ENV", url = "http://0.0.0.0:8080")
        })
public class OpenApiConfig {
}
