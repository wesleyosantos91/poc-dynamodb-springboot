package io.github.wesleyosantos91.api.utils.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.time.LocalDate;

public class LocalDateConverter implements DynamoDBTypeConverter<String, LocalDate> {

    @Override
    public String convert( final LocalDate time ) {
        return time.toString();
    }

    @Override
    public LocalDate unconvert( final String stringValue ) {
        return LocalDate.parse(stringValue);
    }
}
