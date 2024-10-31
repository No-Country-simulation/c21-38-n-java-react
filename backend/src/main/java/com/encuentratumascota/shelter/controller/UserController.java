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
import com.encuentratumascota.shelter.service.AdopterService;
import com.encuentratumascota.shelter.service.AuthService;
import com.encuentratumascota.shelter.service.ShelterService;
import com.encuentratumascota.shelter.util.DataUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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
        List<String> errors = new ArrayList<>();
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        userRegisterDTO.setEmail(adopterDTO.getEmail());
        userRegisterDTO.setPassword(adopterDTO.getPassword());
        userRegisterDTO.setRole(UserRole.ADOPTER);
        userRegisterDTO.setCellphoneNumber(adopterDTO.getCellphoneNumber());
        userRegisterDTO.setImageProfile(adopterDTO.getImageProfile());
        userRegisterDTO.setCountry(adopterDTO.getCountry());
        userRegisterDTO.setCity(adopterDTO.getCity());
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
        adopter.setIdentificationType(adopterDTO.getIdentificationType());
        adopter.setIdentificationNumber(adopterDTO.getIdentificationNumber());

        try {
            RegisterUserDTO response = service.register(userRegisterDTO);
            adopter.setUser(response.getUser());
            Optional<Adopter> adopterResponse =  adopterService.saveAdopter(adopter);
            if(adopterResponse.isPresent()){
                RegisterAdopterDTO responseShelter = new RegisterAdopterDTO(adopterResponse.get(), response.getToken());
                return DataUtils.buildResponse(MessageResponseEnum.ADOPTER_SAVED_SUCCESSFUL,responseShelter,errors);
            }
            return DataUtils.buildResponse(MessageResponseEnum.ADOPTER_NOT_SAVED, null,errors);
        } catch (Exception e) {
            errors.add(e.getMessage());
            return DataUtils.buildResponse(MessageResponseEnum.ADOPTER_NOT_SAVED, null,errors);
        }
    }

    @PostMapping("/shelter")
    public GeneralResponsDTO<RegisterShelterDTO> registerShelter(@RequestBody ShelterDTO shelterDTO) {
        List<String> errors =  new ArrayList<>();
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        userRegisterDTO.setEmail(shelterDTO.getEmail());
        userRegisterDTO.setPassword(shelterDTO.getPassword());
        userRegisterDTO.setRole(UserRole.SHELTER);
        userRegisterDTO.setCellphoneNumber(shelterDTO.getCellphoneNumber());
        userRegisterDTO.setImageProfile(shelterDTO.getImageProfile());
        userRegisterDTO.setCountry(shelterDTO.getCountry());
        userRegisterDTO.setCity(shelterDTO.getCity());
        Shelter shelter = new Shelter();
        shelter.setName(shelterDTO.getName());
        shelter.setMaxCapacity(shelterDTO.getMaxCapacity());
        shelter.setLegalRegistration(shelterDTO.getLegalRegistration());
        try {
            RegisterUserDTO response = service.register(userRegisterDTO);
            shelter.setUser(response.getUser());
            Optional<Shelter> shelterResponse =  shelterService.saveShelter(shelter);
            if(shelterResponse.isPresent()){
                RegisterShelterDTO responseShelter = new RegisterShelterDTO(shelterResponse.get(), response.getToken());
                return DataUtils.buildResponse(MessageResponseEnum.SHELTER_SAVED_SUCCESSFUL,responseShelter,errors);
            }
            return DataUtils.buildResponse(MessageResponseEnum.SHELTER_NOT_SAVED, null,errors);
        } catch (Exception e) {
            errors.add(e.getMessage());
            return DataUtils.buildResponse(MessageResponseEnum.SHELTER_NOT_SAVED, null, errors);
        }
    }

    @PutMapping("/adopter")
    public GeneralResponsDTO<RegisterAdopterDTO> updateAdopter(@RequestBody AdopterUserDTO adopterDTO,@RequestParam String email) {
        List<String> errors = new ArrayList<>();
        Optional<Adopter> adopter = adopterService.getByEmail(email);
        if(adopter.isEmpty()){
            errors.add("No existe un usuario registrado con el email ingresado");
            return DataUtils.buildResponse(MessageResponseEnum.ADOPTER_NOT_FOUND_SUCCESSFUL,null,errors);
        }
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        userRegisterDTO.setEmail(adopterDTO.getEmail());
        userRegisterDTO.setPassword(adopterDTO.getPassword());
        userRegisterDTO.setCellphoneNumber(adopterDTO.getCellphoneNumber());
        userRegisterDTO.setImageProfile(adopterDTO.getImageProfile());
        userRegisterDTO.setCountry(adopterDTO.getCountry());
        userRegisterDTO.setCity(adopterDTO.getCity());

        Adopter adopterUpdate = adopter.get();

        adopterUpdate.setName(adopterDTO.getName());
        adopterUpdate.setLastname(adopterDTO.getLastname());
        adopterUpdate.setBirthDate(adopterDTO.getBirthDate());
        adopterUpdate.setCivilStatus(adopterDTO.getCivilStatus());
        adopterUpdate.setActualPets(adopterDTO.getActualPets());
        adopterUpdate.setFamilyMembers(adopterDTO.getFamilyMembers());
        adopterUpdate.setAdoptionReason(adopterDTO.getAdoptionReason());
        adopterUpdate.setDailyTimeAvailable(adopterDTO.getDailyTimeAvailable());
        adopterUpdate.setHouseType(adopterDTO.getHouseType());
        adopterUpdate.setHouseExtension(adopterDTO.getHouseExtension());
        adopterUpdate.setIdentificationType(adopterDTO.getIdentificationType());
        adopterUpdate.setIdentificationNumber(adopterDTO.getIdentificationNumber());

        try {
            RegisterUserDTO response = service.update(adopterUpdate.getUser().getId(),userRegisterDTO);
            adopterUpdate.setUser(response.getUser());
            Optional<Adopter> adopterResponse =  adopterService.saveAdopter(adopterUpdate);
            if(adopterResponse.isPresent()){
                RegisterAdopterDTO responseShelter = new RegisterAdopterDTO(adopterResponse.get(), response.getToken());
                return DataUtils.buildResponse(MessageResponseEnum.ADOPTER_UPDATED_SUCCESSFUL,responseShelter,errors);
            }
            return DataUtils.buildResponse(MessageResponseEnum.ADOPTER_NOT_UPDATED, null,errors);
        } catch (Exception e) {
            errors.add(e.getMessage());
            return DataUtils.buildResponse(MessageResponseEnum.ADOPTER_NOT_UPDATED, null,errors);
        }
    }

    @PutMapping("/shelter")
    public GeneralResponsDTO<RegisterShelterDTO> updateShelter(@RequestBody ShelterDTO shelterDTO ,@RequestParam String email) {
        List<String> errors =  new ArrayList<>();
        Optional<Shelter> shelter = shelterService.getByEmail(email);
        if(shelter.isEmpty()){
            errors.add("No existe un usuario registrado con el email ingresado");
            return DataUtils.buildResponse(MessageResponseEnum.SHELTER_NOT_UPDATED,null,errors);
        }
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        userRegisterDTO.setEmail(shelterDTO.getEmail());
        userRegisterDTO.setPassword(shelterDTO.getPassword());
        userRegisterDTO.setRole(UserRole.SHELTER);
        userRegisterDTO.setCellphoneNumber(shelterDTO.getCellphoneNumber());
        userRegisterDTO.setImageProfile(shelterDTO.getImageProfile());
        userRegisterDTO.setCountry(shelterDTO.getCountry());
        userRegisterDTO.setCity(shelterDTO.getCity());
        shelter.get().setName(shelterDTO.getName());
        shelter.get().setMaxCapacity(shelterDTO.getMaxCapacity());
        shelter.get().setLegalRegistration(shelterDTO.getLegalRegistration());
        try {
            RegisterUserDTO response = service.update(shelter.get().getUser().getId(),userRegisterDTO);
            shelter.get().setUser(response.getUser());
            Optional<Shelter> shelterResponse =  shelterService.saveShelter(shelter.get());
            if(shelterResponse.isPresent()){
                RegisterShelterDTO responseShelter = new RegisterShelterDTO(shelterResponse.get(), response.getToken());
                return DataUtils.buildResponse(MessageResponseEnum.SHELTER_UPDATED_SUCCESSFUL,responseShelter,errors);
            }
            return DataUtils.buildResponse(MessageResponseEnum.SHELTER_NOT_UPDATED, null,errors);
        } catch (Exception e) {
            errors.add(e.getMessage());
            return DataUtils.buildResponse(MessageResponseEnum.SHELTER_NOT_UPDATED, null, errors);
        }
    }

    @GetMapping("/lists")
        public GeneralResponsDTO<DataListUsersDTO> getLists() {
            return this.userBusiness.getListDataUsers();
        }

    @GetMapping("/shelter")
    public GeneralResponsDTO<Shelter> getShelter(HttpServletRequest request) {
        return this.userBusiness.getShelter(request);
    }

    @GetMapping("/adopter")
    public GeneralResponsDTO<Adopter> getAdopter(HttpServletRequest request) {
        return this.userBusiness.getAdopter(request);
    }



}