package io.github.wesleyosantos91.api.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import io.github.wesleyosantos91.api.entity.Person;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PersonRepository {

    private final DynamoDBMapper mapper;

    public PersonRepository(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    public Person create(Person person) {
         mapper.save(person);
         return person;
    }

    public List<Person> find() {
        return mapper.scan(Person.class, new DynamoDBScanExpression());
    }

    /**
     *
     * Chave composta
     * Partion key id
     * Sort Key cpf
     *
     */
    public Person getByPKAndSK(String id, String cpf) {
        return mapper.load(Person.class, id, cpf);
    }

    public Person update(Person person, String id, String cpf) {
        Person saved = mapper.load(Person.class, id, cpf);
        BeanUtils.copyProperties(person, saved, "id", "cpf");
        mapper.save(saved);
        return saved;
    }

    public void delete(String id, String cpf) {
        Person saved = mapper.load(Person.class, id, cpf);
        mapper.delete(saved);
    }
}
