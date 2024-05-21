package com.jovisco.quarkus.microservices.books;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.test.Mock;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Mock
@RestClient
public class MockNumberProxy implements NumberProxy {

    @Override
    public IsbnThirteen generateIsbn() {
        // mock a ISBN 13 for testing
        log.debug("mocking the ISBN service");
        return IsbnThirteen.builder()
            .isbn13("13-mock")
            .build();
    }
}
