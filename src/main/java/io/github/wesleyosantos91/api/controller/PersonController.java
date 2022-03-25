package io.github.wesleyosantos91.api.controller;

import io.github.wesleyosantos91.api.mapper.PersonMapper;
import io.github.wesleyosantos91.api.request.PersonRequest;
import io.github.wesleyosantos91.api.response.PersonResponse;
import io.github.wesleyosantos91.api.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/persons")
public class PersonController {

    private final PersonService service;
    private final PersonMapper mapper;

    public PersonController(PersonService service, PersonMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<PersonResponse> create(@Valid @RequestBody PersonRequest request) {
        var person = service.create(mapper.toEntity(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(person));
    }

    @GetMapping(value = "/{id}/{cpf}")
    public ResponseEntity<PersonResponse> getById(@PathVariable String id,
                                                  @PathVariable String cpf) {
        var person = service.getByPKAndSK(id, cpf);
        return ResponseEntity.ok().body(mapper.toResponse(person));
    }

    @GetMapping
    public ResponseEntity<List<PersonResponse>> find() {
        var list = service.find().stream().map(mapper::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

    @PutMapping(value = "/{id}/{cpf}")
    public ResponseEntity<PersonResponse> update(@PathVariable String id,
                                                 @PathVariable String cpf,
                                                 @RequestBody PersonRequest request) {

        var person = service.update(mapper.toEntity(request), id, cpf);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toResponse(person));
    }

    @DeleteMapping(value = "/{id}/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable String id,
                                       @PathVariable String cpf) {
        service.delete(id, cpf);
        return ResponseEntity.noContent().build();
    }
}
