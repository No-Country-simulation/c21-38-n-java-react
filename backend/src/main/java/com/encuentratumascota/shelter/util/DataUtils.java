package com.encuentratumascota.shelter.util;

import com.encuentratumascota.shelter.dto.response.DataListDTO;
import com.encuentratumascota.shelter.dto.response.GeneralResponsDTO;
import com.encuentratumascota.shelter.enums.*;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataUtils {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 6;
    private static final SecureRandom RANDOM = new SecureRandom();

    public static <T> GeneralResponsDTO<T> buildResponse(MessageResponseEnum messageResponse, T body, List<String> errors) {
        return GeneralResponsDTO.<T>builder()
                .code(messageResponse.getCode())
                .message(messageResponse.getMessage())
                .errors(errors)
                .body(body).build();
    }

    public static <T> GeneralResponsDTO<T> buildResponseWithError(MessageResponseEnum messageResponse, String errorMessage, T body) {
        return GeneralResponsDTO.<T>builder().code(messageResponse.getCode()).message(messageResponse.getMessage() + errorMessage).body(body).build();
    }

    public static String generateCode() {
        StringBuilder code = new StringBuilder(CODE_LENGTH);
        for (int i = 0; i < CODE_LENGTH; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());
            code.append(CHARACTERS.charAt(index));
        }
        return code.toString();
    }

    public static List<DataListDTO> generateListDataSize() {
        List<DataListDTO> result = new ArrayList<>();
        result.add(new DataListDTO("P", "Pequeño"));
        result.add(new DataListDTO("M", "Mediano"));
        result.add(new DataListDTO("G", "Grande"));
        return result;
    }

    public static List<DataListDTO> generateListDataGender() {
        List<DataListDTO> result = new ArrayList<>();
        result.add(new DataListDTO("H", "Hembra"));
        result.add(new DataListDTO("M", "Macho"));
        return result;
    }

    public static Breed findBreedByName(String name) {
        return Arrays.stream(Breed.values())
                .filter(breed -> breed.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Breed not found: " + name));
    }

    public static List<DataListDTO> getAllBreedData() {
        return Arrays.stream(Breed.values())
                .map(breed -> new DataListDTO(breed.name(), breed.getName()))
                .collect(Collectors.toList());
    }

    public static List<DataListDTO> getAllUserRoles() {
        return Arrays.stream(UserRole.values())
                .map(userRole -> {
                    DataListDTO dataListDTO = new DataListDTO();
                    dataListDTO.setId(userRole.name());
                    dataListDTO.setName(userRole.getName());
                    return dataListDTO;
                })
                .collect(Collectors.toList());
    }

    public static List<DataListDTO> getAllCivilStatuses() {
        return Arrays.stream(CivilStatus.values())
                .map(civilStatus -> new DataListDTO(civilStatus.name(), civilStatus.getText()))
                .collect(Collectors.toList());
    }

    public static List<DataListDTO> getAllHouseTypes() {
        return Arrays.stream(HouseType.values())
                .map(houseType -> new DataListDTO(houseType.name(), houseType.getText()))
                .collect(Collectors.toList());
    }

    public static List<DataListDTO> getAllIdentificationTypes() {
        return Arrays.stream(IdentificationType.values())
                .map(identificationType -> new DataListDTO(identificationType.name(), identificationType.getText()))
                .collect(Collectors.toList());
    }

    public static List<DataListDTO> getAllSpecieData() {
        return Arrays.stream(Specie.values())
                .map(specie -> {
                    DataListDTO dataListDTO = new DataListDTO();
                    dataListDTO.setId(specie.name());
                    dataListDTO.setName(specie.getText());
                    return dataListDTO;
                })
                .collect(Collectors.toList());
    }


}
