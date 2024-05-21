package com.jovisco.quarkus.microservices.numbers.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.jovisco.quarkus.microservices.numbers.domain.IsbnNumber;
import com.jovisco.quarkus.microservices.numbers.dtos.IsbnNumberDto;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IsbnNumberMapper {

    IsbnNumber toEntity(IsbnNumberDto dto);
    IsbnNumberDto toDto(IsbnNumber isbnNumber);
}
