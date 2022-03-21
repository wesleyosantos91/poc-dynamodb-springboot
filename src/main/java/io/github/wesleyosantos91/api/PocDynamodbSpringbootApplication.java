package io.github.wesleyosantos91.api;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import io.github.wesleyosantos91.api.entity.Person;
import io.github.wesleyosantos91.api.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootApplication
public class PocDynamodbSpringbootApplication implements CommandLineRunner {

	private final DynamoDBMapper dynamoDBMapper;

	private final PersonRepository repository;

	public PocDynamodbSpringbootApplication(DynamoDBMapper dynamoDBMapper, PersonRepository repository) {
		this.dynamoDBMapper = dynamoDBMapper;
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(PocDynamodbSpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Iterable<Person> all = repository.findAll();
//
//		for (Person person : all) {
//			System.out.println(person);
//			person.setDateOfBirth(LocalDate.now());
//		}
//
//
//
//		Person p = new Person();
//		p.setCpf("0");
//		p.setName("teste");
//		p.setEmail("email");
//		p.setDateOfBirth(LocalDate.now());
//		repository.save(p);
//
//		Person e = repository.findById("a5a77aed-f1b8-4389-997f-ce9340ffdf99").orElseThrow(RuntimeException::new);
//		e.setName("maria");
//		repository.save(e);
////		dynamoDBMapper.save(e,
////				new DynamoDBSaveExpression()
////						.withExpectedEntry("id",
////								new ExpectedAttributeValue(
////										new AttributeValue().withS("1053fdc67-b2a5-45b4-96a7-d7f23575c805")
////								)));
//
//		System.out.println("new");
		repository.findAll().forEach(System.out::println);
		repository.findAll().forEach((Person person) -> repository.deleteById(person.getId()));
	}
}
