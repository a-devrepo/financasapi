package br.com.nca.financasapi.infrastructure.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Finanças")
                        .version("1.0.0")
                        .description("API REST para gerenciamento de finanças")
                        .termsOfService("https://meusite.com/terms")
                        .contact(new Contact()
                                .name("Suporte Técnico")
                                .email("suporte@autenticacao.com")
                                .url("https://meusite.com/contact"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://springdoc.org")))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8084")
                                .description("Servidor de Desenvolvimento"),
                        new Server()
                                .url("https://api.autenticacao.com")
                                .description("Servidor de Produção")
                ));
    }
}