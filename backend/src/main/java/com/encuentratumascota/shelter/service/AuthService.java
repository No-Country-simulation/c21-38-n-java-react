package com.encuentratumascota.shelter.service;

import com.encuentratumascota.shelter.dto.request.LoginDTO;
import com.encuentratumascota.shelter.dto.request.UserRegisterDTO;
import com.encuentratumascota.shelter.dto.response.AuthDTO;
import com.encuentratumascota.shelter.dto.response.RegisterUserDTO;
import com.encuentratumascota.shelter.model.User;
import com.encuentratumascota.shelter.repository.IUserRepository;
import com.encuentratumascota.shelter.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Implementación del servicio de autenticación.
 */
@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

    private final JwtUtil jwtUtil;

    private final IUserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    /**
     * Realiza la autenticación de un usuario.
     *
     * @param login Los datos de inicio de sesión del usuario.
     * @return Un objeto AuthDTO que contiene el token de autenticación.
     * @throws Exception Si ocurre un error durante el proceso de autenticación.
     */
    @Override
    public AuthDTO login(LoginDTO login) throws Exception {
        try {
            authenticate(login.getEmail(), login.getPassword());

            User user = userRepository.findByEmail(login.getEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            String token = jwtUtil.generateToken(user);
            return new AuthDTO(token);
        } catch (BadCredentialsException | UsernameNotFoundException e) {
            System.out.println(e.getMessage());
            throw new BadCredentialsException("Incorrect username or password");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Registra un nuevo usuario.
     *
     * @param register Los datos de registro del nuevo usuario.
     * @return Un objeto AuthDTO que contiene el token de autenticación.
     * @throws Exception Si ocurre un error durante el proceso de registro.
     */
    @Override
    public RegisterUserDTO register(UserRegisterDTO register) throws Exception {
        try {
            User user = createUserFromRegistration(register);
            user = userRepository.save(user);

            String token = jwtUtil.generateToken(user);

            return new RegisterUserDTO(user,token);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Autentica al usuario utilizando el gestor de autenticación.
     *
     * @param username El nombre de usuario del usuario.
     * @param password La contraseña del usuario.
     */
    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }

    /**
     * Crea un nuevo objeto de usuario a partir de los datos de registro.
     *
     * @param register Los datos de registro del nuevo usuario.
     * @return El usuario creado.
     */
    private User createUserFromRegistration(UserRegisterDTO register) {
        User user = new User();
        //user.setName(register.getName());
        //user.setLastName(register.getLastName());
        user.setEmail(register.getEmail());
        user.setPassword(passwordEncoder.encode(register.getPassword()));
        user.setRole(register.getRole());

        return user;
    }
}