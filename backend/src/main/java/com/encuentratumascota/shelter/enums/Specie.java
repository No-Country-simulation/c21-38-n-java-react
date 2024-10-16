package com.encuentratumascota.shelter.enums;

import com.encuentratumascota.shelter.dto.DataDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Specie {

    DOG("Perro"),
    CAT("Gato");

    private String text;

    private Specie(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public static List<DataDTO> getAllSpecieData() {
        return Arrays.stream(Specie.values())
                .map(specie -> {
                    DataDTO dataDTO = new DataDTO();
                    dataDTO.setId(specie.name());
                    dataDTO.setName(specie.getText());
                    return dataDTO;
                })
                .collect(Collectors.toList());
    }
}
