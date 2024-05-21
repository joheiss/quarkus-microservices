package com.jovisco.quarkus.microservices.numbers;

import java.time.Instant;
import java.util.Random;

import org.eclipse.microprofile.openapi.annotations.Operation;

import com.jovisco.quarkus.microservices.numbers.domain.IsbnNumber;
import com.jovisco.quarkus.microservices.numbers.dtos.IsbnNumberDto;
import com.jovisco.quarkus.microservices.numbers.mappers.IsbnNumberMapper;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/api/v1/numbers")
public class NumberResource {

    @Inject
    IsbnNumberMapper isbnNumberMapper;

    /**
     * Generates an ISBN number in various fomats (13, 10)
     * @return an ISBN number 
     */
    @Operation(summary = "Generates ISBN numbers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public IsbnNumberDto generateIsbn() {

        var isbnNumber = IsbnNumber.builder()
            .isbn13("13-" + new Random().nextInt(100_000_000))
            .isbn10("10-" + new Random().nextInt(100_000))
            .generatedAt(Instant.now())
            .build();

        log.debug("Generated ISBNs: " + isbnNumber.toString());

        return isbnNumberMapper.toDto(isbnNumber);
    }
}
