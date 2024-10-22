package com.encuentratumascota.shelter.converter;

import com.encuentratumascota.shelter.enums.HouseType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class HouseTypeConverter implements AttributeConverter<HouseType, String> {

    @Override
    public String convertToDatabaseColumn(HouseType houseType) {
        return houseType != null ? houseType.getText() : null;
    }

    @Override
    public HouseType convertToEntityAttribute(String dbData) {
        for (HouseType houseType : HouseType.values()) {
            if (houseType.getText().equalsIgnoreCase(dbData)) {
                return houseType;
            }
        }
        throw new IllegalArgumentException("Valor desconocido: " + dbData);
    }
}
