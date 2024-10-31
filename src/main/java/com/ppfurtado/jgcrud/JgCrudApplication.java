package com.ppfurtado.jgcrud;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot Rest Api Documentation",
                description = "Spring Boot Rest Api Documentation Demo",
                version = "V1.0",
                contact = @Contact(
                        name = "Pedro Furtado",
                        email = "furtado.pedropaulo@gmail.comn",
                        url = "pedro-furtado.com.br"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "pedro-furtado.com.br/license"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring Boot Rest Api Documentation",
                url = "pedro-furtado.com.br/user-management.html"
        )
)
public class JgCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(JgCrudApplication.class, args);
    }

}
