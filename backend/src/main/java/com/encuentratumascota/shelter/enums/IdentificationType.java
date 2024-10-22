package com.encuentratumascota.shelter.enums;

import com.encuentratumascota.shelter.dto.response.DataListDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum IdentificationType {

    CC("Cédula de Ciudadanía"),
    TI("Tarjeta de Identidad"),
    CE("Cédula de Extranjería");

    private String text;

    private IdentificationType(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public static List<DataListDTO> getAllUserTypes() {
        return Arrays.stream(IdentificationType.values())
                .map(breed -> {
                    DataListDTO dataListDTO = new DataListDTO();
                    dataListDTO.setId(breed.name());
                    dataListDTO.setName(breed.getText());
                    return dataListDTO;
                })
                .collect(Collectors.toList());
    }



}
