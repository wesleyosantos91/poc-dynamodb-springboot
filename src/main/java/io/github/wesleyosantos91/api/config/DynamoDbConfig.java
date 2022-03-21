package io.github.wesleyosantos91.api.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import lombok.extern.slf4j.Slf4j;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import static com.amazonaws.regions.Regions.SA_EAST_1;


@Slf4j
@Configuration
@EnableDynamoDBRepositories(basePackages = "io.github.wesleyosantos91.api.repository")
public class DynamoDbConfig {

    @Bean
    @Primary
    public DynamoDBMapperConfig dynamoDBMapperConfig() {
        return DynamoDBMapperConfig.DEFAULT;
    }

    @Bean
    @Primary
    public DynamoDBMapper dynamoDBMapper(@Qualifier("amazonDynamoDB") AmazonDynamoDB amazonDynamoDB) {
        return new DynamoDBMapper(amazonDynamoDB);
    }

    @Profile("local")
    @Bean("amazonDynamoDB")
    @Primary
    public AmazonDynamoDB buildAmazonDynamoDBLocal() {
        log.info("init DynamoDB Local");
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", SA_EAST_1.getName()))
                .build();
    }

    @Profile("!local")
    @Bean("amazonDynamoDB")
    @Primary
    public AmazonDynamoDB buildAmazonDynamoDB() {
        log.info("init DynamoDB cloud");
        return AmazonDynamoDBClientBuilder.standard()
                .withRegion(SA_EAST_1)
                .build();
    }
}
