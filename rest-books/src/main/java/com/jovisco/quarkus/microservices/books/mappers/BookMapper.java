package com.jovisco.quarkus.microservices.books.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.jovisco.quarkus.microservices.books.domain.Book;
import com.jovisco.quarkus.microservices.books.dtos.BookDto;


@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookMapper {

    Book toEntity(BookDto dto);
    BookDto toDto(Book book);

}
