package com.encuentratumascota.shelter.service;


import com.encuentratumascota.shelter.dto.response.AuthDTO;
import com.encuentratumascota.shelter.dto.request.LoginDTO;
import com.encuentratumascota.shelter.dto.request.UserRegisterDTO;

/**
 * Interfaz que define los servicios de autenticación en el sistema.
 */
public interface IAuthService {

    AuthDTO login(LoginDTO login) throws Exception;

    AuthDTO register(UserRegisterDTO register) throws Exception;
}