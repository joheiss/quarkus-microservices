package com.jovisco.quarkus.microservices.numbers;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.hasKey;

@QuarkusTest
class NumberResourceTest {
    @Test
    void testGenerateNumbers() {
        given()
            .when().get("/api/v1/numbers")
            .then()
                .statusCode(200)
                .body("isbn_10", startsWith("10-"))
                .body("isbn_13", startsWith("13-"))
                .body(not(hasKey("generatedAt")));
    }

}