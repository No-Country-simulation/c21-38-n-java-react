package com.encuentratumascota.shelter.dto.request;

import com.encuentratumascota.shelter.enums.Breed;
import com.encuentratumascota.shelter.enums.Specie;
import lombok.Data;

@Data
public class PetRequestDTO {

    private String name;
    private Specie specie;
    private Breed breed;
    private String descriptionBreed;
    private Integer age;
    private String gender;
    private String healthStatus;
    private String imageProfile;
    private String size;
}