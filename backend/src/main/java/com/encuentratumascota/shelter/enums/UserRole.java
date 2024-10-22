package com.encuentratumascota.shelter.enums;

import com.encuentratumascota.shelter.dto.response.DataListDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum UserRole {

    ADMIN("Administrador"),
    ADOPTER("Adoptante"),
    SHELTER("Refugio");

    private String name;

    private UserRole(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static List<DataListDTO> getAllUserTypes() {
        return Arrays.stream(UserRole.values())
                .map(breed -> {
                    DataListDTO dataListDTO = new DataListDTO();
                    dataListDTO.setId(breed.name());
                    dataListDTO.setName(breed.getName());
                    return dataListDTO;
                })
                .collect(Collectors.toList());
    }



}
