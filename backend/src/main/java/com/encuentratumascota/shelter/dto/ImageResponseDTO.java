package com.encuentratumascota.shelter.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageResponseDTO {

    private DataImgBBDTO data;

}

