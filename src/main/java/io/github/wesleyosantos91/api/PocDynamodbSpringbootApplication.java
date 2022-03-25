package io.github.wesleyosantos91.api;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocDynamodbSpringbootApplication {

    private final DynamoDBMapper dynamoDBMapper;

    public PocDynamodbSpringbootApplication(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(PocDynamodbSpringbootApplication.class, args);
    }

}
