package com.encuentratumascota.shelter.dto.request;

import com.encuentratumascota.shelter.enums.UserRole;
import lombok.Data;

/**
 * DTO (Data Transfer Object) para almacenar la información necesaria para registrar un nuevo usuario.
 */
@Data
public class UserRegisterDTO {
    String email;
    String password;
    UserRole role;
    private String cellphoneNumber;
    private String imageProfile;
    private String country;
    private String city;
}