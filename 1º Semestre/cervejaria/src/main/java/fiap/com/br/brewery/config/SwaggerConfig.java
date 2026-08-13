package fiap.com.br.brewery.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Beer Guide API",
                description = "API para gerenciamento de cervejarias e cervejas artesanais",
                version = "1.0"
        )
)
public class SwaggerConfig {
}