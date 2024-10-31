package com.encuentratumascota.shelter.model;

import com.encuentratumascota.shelter.converter.UserRoleConverter;
import com.encuentratumascota.shelter.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "user")
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El correo no puede estar vacío")
    @NotNull(message = "El correo no puede ser nulo")
    @Length(max = 100, message = "El correo no puede contener más de 100 caracteres")
    @Email(message = "El formato del correo no es válido")
    @Column(unique = true)
    private String email;


    @NotBlank(message = "La contraseña no puede estar vacía")
    @NotNull(message = "La contraseña no puede ser nula")
    private String password;

    @NotNull(message = "Se dede elegir un tipo de usuario")
    @Enumerated(EnumType.STRING)
    @Convert(converter = UserRoleConverter.class)
    private UserRole role;

    @NotBlank(message = "El número de celular no puede estar vacío")
    private String cellphoneNumber;

    private String imageProfile;

    @NotBlank(message = "El país no puede estar vacío")
    @Length(max = 100, message = "El país no puede contener más de 100 caracteres")
    private String country;

    @NotBlank(message = "La ciudad no puede estar vacía")
    @Length(max = 100, message = "La ciudad no puede contener más de 100 caracteres")
    private String city;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}


