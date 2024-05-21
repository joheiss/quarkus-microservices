package com.jovisco.quarkus.microservices.numbers.domain;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class IsbnNumber {

    private String isbn10;
    private String isbn13;
    private Instant generatedAt;
}
