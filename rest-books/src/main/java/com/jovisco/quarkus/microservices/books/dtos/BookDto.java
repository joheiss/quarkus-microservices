package com.jovisco.quarkus.microservices.books.dtos;

import java.time.Instant;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Schema(description = "Book")
public class BookDto {

    @Schema(required = true)
    @JsonbProperty("isbn_13")
    private String isbn13;
    @Schema(required = true)
    private String title;
    private String author;
    @JsonbProperty("year_of_publication")
    private int yearOfPublication;
    private String genre;
    @JsonbProperty("created_at")
    @JsonbDateFormat("yyyy-MM-dd hh:mm:ss")
    @Schema(implementation = String.class, format = "datetime")
    private Instant createdAt;

}
