package com.jovisco.quarkus.microservices.books;

import jakarta.json.bind.annotation.JsonbProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class IsbnThirteen {

    @JsonbProperty("isbn_13")
    private String isbn13;
}
