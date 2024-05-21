package com.jovisco.quarkus.microservices.numbers;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/")
@OpenAPIDefinition(
    info = @Info(
        title = "ISBN Numbers API", 
        version = "1.0.0",
        description = "Generates ISBN numbers in different formats (10, 13)",
        contact = @Contact(name = "@joheiss", url = "https://twitter.com/joheiss")
    ),
    tags = {
        @Tag(name = "api", description = "Public API to generate ISBN numbers"),
        @Tag(name = "isbn", description = "Generating ISBN numbers")
    }
)
public class NumberMicroService extends Application {}