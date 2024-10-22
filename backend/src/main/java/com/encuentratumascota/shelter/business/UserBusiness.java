package com.encuentratumascota.shelter.business;

import com.encuentratumascota.shelter.dto.response.DataListUsersDTO;
import com.encuentratumascota.shelter.dto.response.GeneralResponsDTO;
import com.encuentratumascota.shelter.enums.MessageResponseEnum;
import com.encuentratumascota.shelter.util.DataUtils;
import org.springframework.stereotype.Component;

@Component
public class UserBusiness {


    public GeneralResponsDTO<DataListUsersDTO> getListDataUsers() {
        DataListUsersDTO result = new DataListUsersDTO();
        result.setCivilStatuses(DataUtils.getAllCivilStatuses());
        result.setUserRoles(DataUtils.getAllUserRoles());
        result.setHouseTypes(DataUtils.getAllHouseTypes());
        result.setIdentificationTypes(DataUtils.getAllIdentificationTypes());
        return DataUtils.buildResponse(MessageResponseEnum.LISTS_DATA_USERS_FOUND_SUCCESSFUL, result);
    }


}
