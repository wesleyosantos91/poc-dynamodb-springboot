package io.github.wesleyosantos91.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig  {

    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("POC - Springboot com DynamoDB")
                        .version("0.0.1")
                        .description("prova de conceito usando springboot com dynamoDB")
                        .termsOfService("http://www.termsofservice.url")
                        .contact(descriptionContact())
                        .license(descriptionLicense())
                );
    }

    private Contact descriptionContact() {
        return new Contact()
                .name("Wesley Oliveira Santos")
                .email("wesleyosantos91@gmail.com")
                .url("wesleyosantos91@github.io");
    }

    private License descriptionLicense() {
        return new License()
                .name("License")
                .url("#");
    }
}
