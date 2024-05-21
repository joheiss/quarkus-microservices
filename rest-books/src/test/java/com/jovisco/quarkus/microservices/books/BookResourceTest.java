package com.jovisco.quarkus.microservices.books;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import com.jovisco.quarkus.microservices.books.dtos.BookDto;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;

@QuarkusTest
class BookResourceTest {
    @Test
    void testCreateBook() {
        var testBook = BookDto.builder()
            .title("The Ultimate Test")
            .author("Jo Heiss")
            .yearOfPublication(2024)
            .genre("IT")
            .build();
        given()
            .body(testBook)
            .contentType(MediaType.APPLICATION_JSON)
            .when()
                .post("/api/v1/books")
            .then()
                .statusCode(201)
                .body("isbn_13", startsWith("13-"))
                .body("title", is(testBook.getTitle()))
                .body("author", is(testBook.getAuthor()))
                .body("genre", is(testBook.getGenre()));
    }

}