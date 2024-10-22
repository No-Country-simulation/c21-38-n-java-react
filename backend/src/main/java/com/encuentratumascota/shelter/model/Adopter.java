package com.encuentratumascota.shelter.model;

import com.encuentratumascota.shelter.converter.CivilStatusConverter;
import com.encuentratumascota.shelter.converter.HouseTypeConverter;
import com.encuentratumascota.shelter.converter.IdentificationTypeConverter;
import com.encuentratumascota.shelter.enums.CivilStatus;
import com.encuentratumascota.shelter.enums.HouseType;
import com.encuentratumascota.shelter.enums.IdentificationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "adopter")
@Entity
public class Adopter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    @Past(message = "La fecha de nacimiento debe ser anterior a la fecha actual")
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @NotNull(message = "Se dede elegir un estado civil")
    @Enumerated(EnumType.STRING)
    @Convert(converter = CivilStatusConverter.class)
    private CivilStatus civilStatus;

    @NotNull(message = "La cantidad de mascotas no puede ser nula")
    @Min(value = 0, message = "La cantidad de mascotas debe ser al menos 0")
    @Column(name = "actual_pets")
    private Integer actualPets;

    @NotNull(message = "El número de miembros de la familia no puede ser nulo")
    @Min(value = 1, message = "El número de miembros de la familia debe ser al menos 1")
    @Column(name = "family_members")
    private Integer familyMembers;

    @Size(max = 255, message = "La razón de adopción no puede exceder los 255 caracteres")
    @Column(name = "adoption_reason")
    private String adoptionReason;

    @NotNull(message = "El tiempo diario disponible no puede ser nulo")
    @Min(value = 0, message = "El tiempo diario disponible debe ser al menos 0")
    private Integer dailyTimeAvailable;

    @NotNull(message = "Se dede elegir un tipo de vivienda")
    @Enumerated(EnumType.STRING)
    @Convert(converter = HouseTypeConverter.class)
    private HouseType houseType;

    @NotNull(message = "La extensión de la casa no puede ser nula")
    @Min(value = 1, message = "La extensión de la casa debe ser al menos 1")
    private Integer houseExtension;

    @NotBlank(message = "El nombre no puede estar vacío")
    @NotNull(message = "El nombre no puede ser nulo")
    @Length(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
    @Pattern(
            regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$",
            message = "El nombre solo puede contener letras, tildes, espacios y la letra ñ"
    )
    private String name;

    @NotBlank(message = "El apellido no puede estar vacío")
    @NotNull(message = "El apellido no puede ser nulo")
    @Length(min = 1, max = 50, message = "El apellido debe tener entre 1 y 50 caracteres")
    @Pattern(
            regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$",
            message = "El apellido solo puede contener letras, tildes, espacios y la letra ñ"
    )
    private String lastname;

    @NotNull(message = "Se dede elegir un tipo de identificacion")
    @Enumerated(EnumType.STRING)
    @Convert(converter = IdentificationTypeConverter.class)
    private IdentificationType identificationType;

    @NotNull(message = "El número de identificación no puede ser nulo")
    @Min(value = 1, message = "El número de identificación debe ser mayor que 0")
    private Integer identificationNumber;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}


