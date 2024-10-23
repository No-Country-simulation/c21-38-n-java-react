package com.encuentratumascota.shelter.controller;

import com.encuentratumascota.shelter.business.UserBusiness;
import com.encuentratumascota.shelter.dto.request.AdopterUserDTO;
import com.encuentratumascota.shelter.dto.request.LoginDTO;
import com.encuentratumascota.shelter.dto.request.ShelterDTO;
import com.encuentratumascota.shelter.dto.request.UserRegisterDTO;
import com.encuentratumascota.shelter.dto.response.*;
import com.encuentratumascota.shelter.enums.MessageResponseEnum;
import com.encuentratumascota.shelter.enums.UserRole;
import com.encuentratumascota.shelter.model.Adopter;
import com.encuentratumascota.shelter.model.Shelter;
import com.encuentratumascota.shelter.model.User;
import com.encuentratumascota.shelter.service.AdopterService;
import com.encuentratumascota.shelter.service.AuthService;
import com.encuentratumascota.shelter.service.ShelterService;
import com.encuentratumascota.shelter.util.DataUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class UserController {

    private final AuthService service;

    @Autowired
    private final UserBusiness userBusiness;

    @Autowired
    private final AdopterService adopterService;
    @Autowired
    private final ShelterService shelterService;



    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.login(dto));
        } catch (BadCredentialsException | UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("{\"error\": \"Invalid credentials\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @PostMapping("/adopter")
    public GeneralResponsDTO<RegisterAdopterDTO> registerAdopter(@RequestBody AdopterUserDTO adopterDTO) {
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        userRegisterDTO.setEmail(adopterDTO.getEmail());
        userRegisterDTO.setPassword(adopterDTO.getPassword());
        userRegisterDTO.setRole(UserRole.ADOPTER);
        Adopter adopter = new Adopter();
        adopter.setName(adopterDTO.getName());
        adopter.setLastname(adopterDTO.getLastname());
        adopter.setBirthDate(adopterDTO.getBirthDate());
        adopter.setCivilStatus(adopterDTO.getCivilStatus());
        adopter.setActualPets(adopterDTO.getActualPets());
        adopter.setFamilyMembers(adopterDTO.getFamilyMembers());
        adopter.setAdoptionReason(adopterDTO.getAdoptionReason());
        adopter.setDailyTimeAvailable(adopterDTO.getDailyTimeAvailable());
        adopter.setHouseType(adopterDTO.getHouseType());
        adopter.setHouseExtension(adopterDTO.getHouseExtension());
        User user = new User();
        user.setEmail(userRegisterDTO.getEmail());
        user.setRole(userRegisterDTO.getRole());
        user.setPassword(userRegisterDTO.getPassword());
        user.setCellphoneNumber(adopterDTO.getCellphoneNumber());
        user.setImageProfile(adopterDTO.getImageProfile());
        user.setCountry(adopterDTO.getCountry());
        user.setCity(adopterDTO.getCity());
        try {
            RegisterUserDTO response = service.register(userRegisterDTO);
            adopter.setUser(response.getUser());
            Optional<Adopter> adopterResponse =  adopterService.saveAdopter(adopter);
            if(adopterResponse.isPresent()){
                RegisterAdopterDTO responseShelter = new RegisterAdopterDTO(adopterResponse.get(), response.getToken());
                return DataUtils.buildResponse(MessageResponseEnum.ADOPTER_SAVED_SUCCESSFUL,responseShelter);
            }
            return DataUtils.buildResponse(MessageResponseEnum.ADOPTER_NOT_SAVED, null);
        } catch (Exception e) {
            return DataUtils.buildResponse(MessageResponseEnum.ADOPTER_NOT_SAVED, null);
        }
    }

    @PostMapping("/shelter")
    public GeneralResponsDTO<RegisterShelterDTO> registerShelter(@RequestBody ShelterDTO shelterDTO) {
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        userRegisterDTO.setEmail(shelterDTO.getEmail());
        userRegisterDTO.setPassword(shelterDTO.getPassword());
        userRegisterDTO.setRole(UserRole.SHELTER);
        Shelter shelter = new Shelter();
        shelter.setName(shelterDTO.getName());
        shelter.setMaxCapacity(shelterDTO.getMaxCapacity());
        shelter.setLegalRegistration(shelterDTO.getLegalRegistration());
        User user = new User();
        user.setEmail(userRegisterDTO.getEmail());
        user.setRole(userRegisterDTO.getRole());
        user.setPassword(userRegisterDTO.getPassword());
        user.setCellphoneNumber(shelterDTO.getCellphoneNumber());
        user.setImageProfile(shelterDTO.getImageProfile());
        user.setCountry(shelterDTO.getCountry());
        user.setCity(shelterDTO.getCity());
        try {
            RegisterUserDTO response = service.register(userRegisterDTO);
            shelter.setUser(response.getUser());
            Optional<Shelter> shelterResponse =  shelterService.saveShelter(shelter);
            if(shelterResponse.isPresent()){
                RegisterShelterDTO responseShelter = new RegisterShelterDTO(shelterResponse.get(), response.getToken());
                return DataUtils.buildResponse(MessageResponseEnum.SHELTER_SAVED_SUCCESSFUL,responseShelter);
            }
            return DataUtils.buildResponse(MessageResponseEnum.SHELTER_NOT_SAVED, null);
        } catch (Exception e) {
            return DataUtils.buildResponse(MessageResponseEnum.SHELTER_NOT_SAVED, null);
        }
    }

    @GetMapping("/lists")
        public GeneralResponsDTO<DataListUsersDTO> getLists() {
            return this.userBusiness.getListDataUsers();
        }



}