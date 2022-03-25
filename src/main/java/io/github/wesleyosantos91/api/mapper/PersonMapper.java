package io.github.wesleyosantos91.api.mapper;

import io.github.wesleyosantos91.api.entity.Person;
import io.github.wesleyosantos91.api.request.PersonRequest;
import io.github.wesleyosantos91.api.response.PersonResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person toEntity(PersonRequest request);
    PersonResponse toResponse(Person person);
}
