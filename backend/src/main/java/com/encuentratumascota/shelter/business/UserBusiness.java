package com.encuentratumascota.shelter.business;

import com.encuentratumascota.shelter.dto.response.DataListUsersDTO;
import com.encuentratumascota.shelter.dto.response.GeneralResponsDTO;
import com.encuentratumascota.shelter.enums.MessageResponseEnum;
import com.encuentratumascota.shelter.service.AdopterService;
import com.encuentratumascota.shelter.service.AuthService;
import com.encuentratumascota.shelter.service.ShelterService;
import com.encuentratumascota.shelter.util.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserBusiness {

    @Autowired
    private AuthService service;
    @Autowired
    private AdopterService adopterService;
    @Autowired
    private ShelterService shelterService;

    public GeneralResponsDTO<DataListUsersDTO> getListDataUsers() {
        DataListUsersDTO result = new DataListUsersDTO();
        result.setCivilStatuses(DataUtils.getAllCivilStatuses());
        result.setUserRoles(DataUtils.getAllUserRoles());
        result.setHouseTypes(DataUtils.getAllHouseTypes());
        result.setIdentificationTypes(DataUtils.getAllIdentificationTypes());
        return DataUtils.buildResponse(MessageResponseEnum.LISTS_DATA_USERS_FOUND_SUCCESSFUL, result);
    }
}
