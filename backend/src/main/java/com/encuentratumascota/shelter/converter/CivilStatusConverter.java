package com.encuentratumascota.shelter.converter;

import com.encuentratumascota.shelter.enums.CivilStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CivilStatusConverter implements AttributeConverter<CivilStatus, String> {

    @Override
    public String convertToDatabaseColumn(CivilStatus civilStatus) {
        return civilStatus != null ? civilStatus.getText() : null;
    }

    @Override
    public CivilStatus convertToEntityAttribute(String dbData) {
        for (CivilStatus civilStatus : CivilStatus.values()) {
            if (civilStatus.getText().equalsIgnoreCase(dbData)) {
                return civilStatus;
            }
        }
        throw new IllegalArgumentException("Valor desconocido: " + dbData);
    }
}
