package com.jovisco.quarkus.microservices.books.domain;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Book {

    private String isbn13;
    private String title;
    private String author;
    private int yearOfPublication;
    private String genre;
    private Instant createdAt;

}
