package com.encuentratumascota.shelter.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DataListPetsDTO {
    private List<DataListDTO> gender;
    private List<DataListDTO> breeds;
    private List<DataListDTO> species;
    private List<DataListDTO> size;
}
