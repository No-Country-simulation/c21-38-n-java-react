package com.encuentratumascota.shelter.dto.request;

import lombok.Data;

/**
 * DTO (Data Transfer Object) para almacenar las credenciales de inicio de sesión.
 */
@Data
public class LoginDTO {
    String email;
    String password;
}