package com.encuentratumascota.shelter.model;

import com.encuentratumascota.shelter.enums.AdoptionStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "adoptions")
public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Se debe seleccionar una mascota")
    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    @NotNull(message = "Se debe seleccionar un adoptante")
    @ManyToOne
    @JoinColumn(name = "adopter_id", nullable = false)
    private Adopter adopter;

    @NotNull(message = "La fecha de adopción no puede ser nula")
    private String adoptionDate; // Considera usar LocalDate

    @NotNull(message = "El estado de adopción no puede ser nulo")
    @Enumerated(EnumType.STRING)
    private AdoptionStatus status; // Nuevo atributo para el estado de la adopción

    // Puedes agregar más atributos, como notas, etc.
}
