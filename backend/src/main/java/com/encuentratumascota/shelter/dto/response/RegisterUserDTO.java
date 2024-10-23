package com.encuentratumascota.shelter.dto.response;

import com.encuentratumascota.shelter.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO (Data Transfer Object) que representa la autenticación con un token.
 */
@Data @AllArgsConstructor
public class RegisterUserDTO {
    User user;
    String token;
}