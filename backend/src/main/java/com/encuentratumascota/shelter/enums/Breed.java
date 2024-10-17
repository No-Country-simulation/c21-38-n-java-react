package com.encuentratumascota.shelter.enums;

import com.encuentratumascota.shelter.dto.DataDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Breed {

    //Dogs
    DOBERMAN("Doberman"),
    POODLE("Poddle"),
    BORDER_COLLIE("Border Collie"),
    CRIOLLO("Criollo"),

    // Cats
    ANGORA("Angora"),
    SIAMESE("Siames"),
    MAINE_COON("Maine Coon"),
    PERSIAN("Persa"),
    SPHINX("Sphinx");
    private String text;

    private Breed(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public static List<DataDTO> getAllBreedData() {
        return Arrays.stream(Breed.values())
                .map(breed -> {
                    DataDTO dataDTO = new DataDTO();
                    dataDTO.setId(breed.name());
                    dataDTO.setName(breed.getText());
                    return dataDTO;
                })
                .collect(Collectors.toList());
    }

}
