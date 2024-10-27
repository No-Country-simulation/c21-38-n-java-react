package com.encuentratumascota.shelter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "shelter")
@Entity
public class Shelter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @NotNull(message = "El nombre no puede ser nulo")
    @Length(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
    @Pattern(
            regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$",
            message = "El nombre solo puede contener letras, tildes, espacios y la letra ñ"
    )
    private String name;

    @NotNull(message = "La capacidad máxima no puede ser nula")
    @Min(value = 1, message = "La capacidad máxima debe ser al menos 1")
    @Max(value = 1000, message = "La capacidad máxima no puede exceder 1000")
    private Integer maxCapacity;

    @NotNull(message = "El registro legal no puede ser nulo")
    @Size(min = 1, max = 50, message = "El registro legal debe tener entre 1 y 50 caracteres")
    @Column(name = "legal_registration", nullable = false, length = 50)
    private String legalRegistration;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;




    
}


