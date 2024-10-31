package com.encuentratumascota.shelter.business;

import com.encuentratumascota.shelter.dto.response.DataListUsersDTO;
import com.encuentratumascota.shelter.dto.response.GeneralResponsDTO;
import com.encuentratumascota.shelter.enums.MessageResponseEnum;
import com.encuentratumascota.shelter.model.Adopter;
import com.encuentratumascota.shelter.model.Shelter;
import com.encuentratumascota.shelter.service.AdopterService;
import com.encuentratumascota.shelter.service.AuthService;
import com.encuentratumascota.shelter.service.ShelterService;
import com.encuentratumascota.shelter.util.DataUtils;
import com.encuentratumascota.shelter.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserBusiness {

    @Autowired
    private AuthService service;
    @Autowired
    private AdopterService adopterService;
    @Autowired
    private ShelterService shelterService;

    @Autowired
    private JwtUtil jwtUtil;

    public GeneralResponsDTO<DataListUsersDTO> getListDataUsers() {
        List<String> errors = new ArrayList<>();
        DataListUsersDTO result = new DataListUsersDTO();
        result.setCivilStatuses(DataUtils.getAllCivilStatuses());
        result.setUserRoles(DataUtils.getAllUserRoles());
        result.setHouseTypes(DataUtils.getAllHouseTypes());
        result.setIdentificationTypes(DataUtils.getAllIdentificationTypes());
        return DataUtils.buildResponse(MessageResponseEnum.LISTS_DATA_USERS_FOUND_SUCCESSFUL, result,errors);
    }

    public GeneralResponsDTO<Shelter> getShelter(HttpServletRequest request) {
        List<String> errors = new ArrayList<>();
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = request.getHeader("Authorization").substring(7);
            String username = jwtUtil.getUsernameFromToken(token);
            Optional<Shelter> shelter = shelterService.getByEmail(username);
            if (shelter.isEmpty()) {
                errors.add("El refugio no está registrado en el sistema");
                return DataUtils.buildResponse(MessageResponseEnum.USER_NOT_FOUND, null, errors);
            }
            return DataUtils.buildResponse(MessageResponseEnum.USER_FOUND_SUCCESSFUL, shelter.get(), errors);
        }
        return DataUtils.buildResponse(MessageResponseEnum.USER_NOT_FOUND, null, errors);
    }

    public GeneralResponsDTO<Adopter> getAdopter(HttpServletRequest request) {
        List<String> errors = new ArrayList<>();
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = request.getHeader("Authorization").substring(7);
            String username = jwtUtil.getUsernameFromToken(token);
            Optional<Adopter> shelter = adopterService.getByEmail(username);
            if (shelter.isEmpty()) {
                errors.add("El adoptante no está registrado en el sistema");
                return DataUtils.buildResponse(MessageResponseEnum.USER_NOT_FOUND, null, errors);
            }
            return DataUtils.buildResponse(MessageResponseEnum.USER_FOUND_SUCCESSFUL, shelter.get(), errors);
        }
        return DataUtils.buildResponse(MessageResponseEnum.USER_NOT_FOUND, null, errors);
    }



}
