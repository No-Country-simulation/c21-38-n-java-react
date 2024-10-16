package com.encuentratumascota.shelter.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DataListPetsDTO {
    private List<DataDTO> gender;
    private List<DataDTO> breeds;
    private List<DataDTO> species;
    private List<DataDTO> size;
}
