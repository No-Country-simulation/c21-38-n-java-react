package com.encuentratumascota.shelter.converter;

import com.encuentratumascota.shelter.enums.Specie;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SpecieConverter implements AttributeConverter<Specie, String> {

    @Override
    public String convertToDatabaseColumn(Specie specie) {
        return specie != null ? specie.getText() : null;
    }

    @Override
    public Specie convertToEntityAttribute(String dbData) {
        for (Specie specie : Specie.values()) {
            if (specie.getText().equalsIgnoreCase(dbData)) {
                return specie;
            }
        }
        throw new IllegalArgumentException("Valor desconocido: " + dbData);
    }
}

