package fiap.com.br.cervejaria.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Cervejaria API",
                description = "API para gerenciamento de estilos e cervejarias",
                version = "1.0"
        )
)
public class SwaggerConfig {
}