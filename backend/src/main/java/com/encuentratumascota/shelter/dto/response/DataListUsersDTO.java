package com.encuentratumascota.shelter.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DataListUsersDTO {
    private List<DataListDTO> civilStatuses;
    private List<DataListDTO> houseTypes;
    private List<DataListDTO> identificationTypes;
    private List<DataListDTO> userRoles;
}
