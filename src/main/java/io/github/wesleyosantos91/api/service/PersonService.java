package io.github.wesleyosantos91.api.service;

import io.github.wesleyosantos91.api.entity.Person;
import io.github.wesleyosantos91.api.exception.ObjectNotFoundException;
import io.github.wesleyosantos91.api.repository.PersonRepository;
import io.github.wesleyosantos91.api.request.PersonRequest;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

@Service
public class PersonService {
    
    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person create(Person person) {
        return repository.create(person);
    }

    public List<Person> find() {
        return repository.find();
    }

    public Person getByPKAndSK(String id, String cpf) {

        Person person = repository.getByPKAndSK(id, cpf);

        if (Objects.nonNull(person)) {
            return person;
        }

        throw new ObjectNotFoundException(MessageFormat.format("Person with id {0} and cpf {1} not found", id, cpf));
    }

    public Person update(Person person, String id, String cpf) {
        return repository.update(person, id, cpf);
    }

    public void delete(String id, String cpf) {
        repository.delete(id, cpf);
    }
}
