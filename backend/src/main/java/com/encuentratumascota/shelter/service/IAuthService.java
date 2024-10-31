package com.encuentratumascota.shelter.service;


import com.encuentratumascota.shelter.dto.response.AuthDTO;
import com.encuentratumascota.shelter.dto.request.LoginDTO;
import com.encuentratumascota.shelter.dto.request.UserRegisterDTO;
import com.encuentratumascota.shelter.dto.response.RegisterUserDTO;

/**
 * Interfaz que define los servicios de autenticación en el sistema.
 */
public interface IAuthService {

    AuthDTO login(LoginDTO login) throws Exception;

    RegisterUserDTO register(UserRegisterDTO register) throws Exception;

    RegisterUserDTO update(Long userId,UserRegisterDTO register) throws Exception;

}