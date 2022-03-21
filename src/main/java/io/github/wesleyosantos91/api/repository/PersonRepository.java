package io.github.wesleyosantos91.api.repository;

import io.github.wesleyosantos91.api.entity.Person;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface PersonRepository extends DynamoDBCrudRepository<Person, String> {
}
