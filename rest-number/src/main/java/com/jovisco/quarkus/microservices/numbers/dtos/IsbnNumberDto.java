package com.jovisco.quarkus.microservices.numbers.dtos;

import java.time.Instant;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Schema(description = "Various ISBN formats")
public class IsbnNumberDto {

    @Schema(required = true)
    @JsonbProperty("isbn_10")
    private String isbn10;
    @Schema(required = true)
    @JsonbProperty("isbn_13")
    private String isbn13;
    @JsonbTransient
    private Instant generatedAt;
}
