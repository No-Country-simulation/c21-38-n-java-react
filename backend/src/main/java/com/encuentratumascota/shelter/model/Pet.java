package com.encuentratumascota.shelter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @NotNull(message = "El nombre no puede ser nulo")
    @Length(min = 7, max = 8,message = "El nombre no puede contener más de 100 caractéres")
    @Pattern(regexp = "^[A-Za-zÑñ ]+$", message = "El nombre solo puede contener letras y espacios, sin caracteres especiales.")
    private String name;
    
    private Specie specie;
    private String descriptionSpecie;
    private Breed breed;
    private int edge;
    private char gender;
    private String healthStatus;
    private String imageProfile;
    private char size;
    private boolean activeStatus;

}
