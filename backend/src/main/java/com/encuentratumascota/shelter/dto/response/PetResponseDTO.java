package com.encuentratumascota.shelter.dto.response;

import lombok.Data;

@Data
public class PetResponseDTO {

    private Long id;
    private String name;
    private String specie;
    private String breed;
    private String descriptionBreed;
    private Integer age;
    private String gender;
    private String healthStatus;
    private String imageProfile;
    private String size;
}