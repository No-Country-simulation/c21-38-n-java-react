package com.encuentratumascota.shelter.converter;

import com.encuentratumascota.shelter.enums.Breed;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BreedConverter implements AttributeConverter<Breed, String> {

    @Override
    public String convertToDatabaseColumn(Breed breed) {
        return breed != null ? breed.getName() : null;
    }

    @Override
    public Breed convertToEntityAttribute(String dbData) {
        for (Breed breed : Breed.values()) {
            if (breed.getName().equalsIgnoreCase(dbData)) {
                return breed;
            }
        }
        throw new IllegalArgumentException("Valor desconocido: " + dbData);
    }
}
