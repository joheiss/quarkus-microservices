package com.jovisco.quarkus.microservices.books;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Instant;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.jovisco.quarkus.microservices.books.domain.Book;
import com.jovisco.quarkus.microservices.books.dtos.BookDto;
import com.jovisco.quarkus.microservices.books.mappers.BookMapper;

import jakarta.inject.Inject;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Book REST Endpoint")
@Slf4j
@Path("/api/v1/books")
public class BookResource {

    @Inject
    @RestClient
    NumberProxy proxy;

    @Inject
    BookMapper bookMapper;

    @Operation(summary = "Creates a new book")
    @APIResponse(responseCode = "201", description = "Book created")
    @APIResponse(responseCode = "400", description = "Bad request")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Retry(maxRetries = 1, delay = 2000)
    @Fallback(fallbackMethod = "fallbackOnCreateBook")
    public Response createBook(BookDto dto) {

        var book = Book.builder()
            .isbn13(proxy.generateIsbn().getIsbn13())
            .title(dto.getTitle())
            .author(dto.getAuthor())
            .yearOfPublication(dto.getYearOfPublication())
            .genre(dto.getGenre())
            .createdAt(Instant.now())
            .build();

        log.debug("Book created: " + book.toString());

        return Response.status(Status.CREATED)
            .entity(bookMapper.toDto(book))
            .build(); 
    }

    public Response fallbackOnCreateBook(BookDto dto) throws FileNotFoundException {

        var book = Book.builder()
            .isbn13("<later>")
            .title(dto.getTitle())
            .author(dto.getAuthor())
            .yearOfPublication(dto.getYearOfPublication())
            .genre(dto.getGenre())
            .createdAt(Instant.now())
            .build();

        log.debug("Temporary Book created: " + book.toString());

        saveTemporaryBookOnDisk(book);

        return Response.status(Status.PARTIAL_CONTENT)
            .entity(bookMapper.toDto(book))
            .build(); 

    }

    private void saveTemporaryBookOnDisk(Book book) throws FileNotFoundException {

        var bookJson = JsonbBuilder.create().toJson(book);

        var fileName = "temp-book-" + Instant.now().toEpochMilli() + ".json";
        try (var out = new PrintWriter(fileName)) {
            out.println(bookJson);
            log.warn("Temporary book saved at: " + fileName);
        }
    }
}