package com.encuentratumascota.shelter.converter;

import com.encuentratumascota.shelter.enums.IdentificationType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class IdentificationTypeConverter implements AttributeConverter<IdentificationType, String> {

    @Override
    public String convertToDatabaseColumn(IdentificationType identificationType) {
        return identificationType != null ? identificationType.getText() : null;
    }

    @Override
    public IdentificationType convertToEntityAttribute(String dbData) {
        for (IdentificationType identificationType : IdentificationType.values()) {
            if (identificationType.getText().equalsIgnoreCase(dbData)) {
                return identificationType;
            }
        }
        throw new IllegalArgumentException("Valor desconocido: " + dbData);
    }
}
