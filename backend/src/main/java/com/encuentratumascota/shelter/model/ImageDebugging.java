package com.encuentratumascota.shelter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "image_debugging")
@Entity
public class ImageDebugging {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @NotNull(message = "El nombre no puede ser nulo")
    @Length(min = 1, max = 50,message = "El nombre no puede contener más de 50 caractéres")
    private String imageName;

    @NotNull(message ="El tipo de imagen no puede ser nulo")
    @NotBlank(message ="El tipo de imagen no puede estar vacío")
    private String type;

    @URL(message = "La URL de la imagen de perfil debe ser válida")
    @Length(max = 250, message = "La imagen de perfil no puede contener más de 250 caracteres")
    private String urlImage;


}


