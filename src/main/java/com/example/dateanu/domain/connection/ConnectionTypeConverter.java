package com.example.dateanu.domain.connection;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class ConnectionTypeConverter implements AttributeConverter<ConnectionType, String> {
    @Override
    public String convertToDatabaseColumn(ConnectionType connectionType) {
        if (connectionType == null) {
            return null;
        }
        return connectionType.getText();
    }

    @Override
    public ConnectionType convertToEntityAttribute(String text) {
        if (text == null) {
            return null;
        }

        return Stream.of(ConnectionType.values())
                .filter(c -> c.getText().equals(text))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
