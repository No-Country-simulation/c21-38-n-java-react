package com.encuentratumascota.shelter.dto.request;

import lombok.Data;

@Data
public class ShelterDTO {
    private String name;
    private Integer maxCapacity;
    private String legalRegistration;
    private String email;
    private String password;
    private String cellphoneNumber;
    private String imageProfile;
    private String country;
    private String city;
}