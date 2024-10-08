package com.encuentratumascota.shelter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import com.encuentratumascota.shelter.enums.Breed;
import com.encuentratumascota.shelter.enums.Specie;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "pets")
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @NotNull(message = "El nombre no puede ser nulo")
    @Length(min = 1, max = 50,message = "El nombre no puede contener más de 50 caractéres")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$", message = "El nombre solo puede contener letras, tildes, espacios y ñ.")
    private String name;

    @NotNull(message = "Se dede elegir una especie")
    @Enumerated(EnumType.STRING)
    private Specie specie;

    @NotNull(message = "Se dede elegir una raza")
    @Enumerated(EnumType.STRING)
    private Breed breed;

    @Length(max = 250,message = "La descripción de la especie no puede contener más de 250 caractéres")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ0-9 .,'()\\-/]*$", message = "La descripción solo puede contener letras, números, espacios y ciertos caracteres especiales como /, (), - y puntos.")
    private String descriptionBreed;

    @NotNull(message = "La edad no puede ser nula")
    @Min(value = 1, message = "La edad debe ser mayor o igual a 1")
    @Max(value = 999, message = "La edad debe ser menor o igual a 999")
    private Integer age;

    @NotBlank(message = "El género no puede estar vacío")
    @NotNull(message = "El género no puede ser nulo")
    @Pattern(regexp = "[MmHh]", message = "El género solo puede ser 'M' (macho) o 'H' (hembra)")
    private String gender;

    @Length(max = 500, message = "El estado de salud no puede contener más de 500 caracteres")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ0-9 .,'()\\-/]*$", message = "El estado de salud solo puede contener letras, números, espacios y ciertos caracteres especiales como /, (), - y puntos.")
    private String healthStatus;

    @URL(message = "La URL de la imagen de perfil debe ser válida")
    @Length(max = 250, message = "La imagen de perfil no puede contener más de 250 caracteres")
    private String imageProfile;

    @NotBlank(message = "El tamaño no puede estar vacío")
    @NotNull(message = "El tamaño no puede ser nulo")
    @Pattern(regexp = "[PpMmGg]", message = "El tamaño solo puede ser 'P' (pequeño), 'M' (mediano) o 'G' (grande)")
    private String size;

    private boolean activeStatus;

}
