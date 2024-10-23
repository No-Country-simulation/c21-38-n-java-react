package com.encuentratumascota.shelter.dto.request;

import com.encuentratumascota.shelter.enums.CivilStatus;
import com.encuentratumascota.shelter.enums.HouseType;
import com.encuentratumascota.shelter.enums.IdentificationType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AdopterUserDTO {

    private LocalDate birthDate;
    private CivilStatus civilStatus;
    private Integer actualPets;
    private Integer familyMembers;
    private String adoptionReason;
    private Integer dailyTimeAvailable;
    private HouseType houseType;
    private Integer houseExtension;
    private String name;
    private String lastname;
    private IdentificationType identificationType;
    private Integer identificationNumber;

    private String email;
    private String password;
    private String cellphoneNumber;
    private String imageProfile;
    private String country;
    private String city;
}