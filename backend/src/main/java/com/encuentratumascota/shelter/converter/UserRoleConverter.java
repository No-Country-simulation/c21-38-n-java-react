package com.encuentratumascota.shelter.converter;

import com.encuentratumascota.shelter.enums.UserRole;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class UserRoleConverter implements AttributeConverter<UserRole, String> {

    @Override
    public String convertToDatabaseColumn(UserRole userRole) {
        return userRole != null ? userRole.getName() : null;
    }

    @Override
    public UserRole convertToEntityAttribute(String dbData) {
        for (UserRole userRole : UserRole.values()) {
            if (userRole.getName().equalsIgnoreCase(dbData)) {
                return userRole;
            }
        }
        throw new IllegalArgumentException("Valor desconocido: " + dbData);
    }
}
