package com.encuentratumascota.shelter.model;

import com.encuentratumascota.shelter.converter.UserRoleConverter;
import com.encuentratumascota.shelter.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El correo no puede estar vacío")
    @NotNull(message = "El correo no puede ser nulo")
    @Length(max = 100, message = "El correo no puede contener más de 100 caracteres")
    @Email(message = "El formato del correo no es válido")
    private String email;


    @NotBlank(message = "La contraseña no puede estar vacía")
    @NotNull(message = "La contraseña no puede ser nula")
    @Length(min = 8, max = 20, message = "La contraseña debe tener entre 8 y 20 caracteres")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
            message = "La contraseña debe contener al menos una mayúscula, una minúscula, un número y un carácter especial"
    )
    private String password;

    @NotBlank(message = "El número de celular no puede estar vacío")
    @NotNull(message = "El número de celular no puede ser nulo")
    @Pattern(
            regexp = "^\\+?[1-9][0-9]{7,14}$",
            message = "El número de celular debe contener entre 8 y 15 dígitos, y puede incluir un prefijo internacional con +"
    )
    private String cellphoneNumber;

    @NotNull(message = "Se dede elegir un tipo de usuario")
    @Enumerated(EnumType.STRING)
    @Convert(converter = UserRoleConverter.class)
    private UserRole role;

    @URL(message = "La URL de la imagen de perfil debe ser válida")
    @Length(max = 250, message = "La imagen de perfil no puede contener más de 250 caracteres")
    private String imageProfile;

    @NotNull(message = "El país no puede ser nulo")
    @Size(min = 1, max = 100, message = "El país debe tener entre 1 y 100 caracteres")
    @Column(name = "country", nullable = false, length = 100)
    private String country;

    @NotNull(message = "La ciudad no puede ser nula")
    @Size(min = 1, max = 100, message = "La ciudad debe tener entre 1 y 100 caracteres")
    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Shelter shelter;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Adopter adopter;


}


