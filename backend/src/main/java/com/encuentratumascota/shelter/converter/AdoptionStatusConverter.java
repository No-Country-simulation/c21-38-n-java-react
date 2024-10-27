package com.encuentratumascota.shelter.converter;

import com.encuentratumascota.shelter.enums.AdoptionStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AdoptionStatusConverter implements AttributeConverter<AdoptionStatus, String> {

    @Override
    public String convertToDatabaseColumn(AdoptionStatus adoptionStatus) {
        return adoptionStatus != null ? adoptionStatus.getName() : null;
    }

    @Override
    public AdoptionStatus convertToEntityAttribute(String dbData) {
        for (AdoptionStatus adoptionStatus : AdoptionStatus.values()) {
            if (adoptionStatus.getName().equalsIgnoreCase(dbData)) {
                return adoptionStatus;
            }
        }
        throw new IllegalArgumentException("Valor desconocido: " + dbData);
    }
}
