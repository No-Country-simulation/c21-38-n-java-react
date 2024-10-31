package com.encuentratumascota.shelter.service;

import com.encuentratumascota.shelter.enums.AdoptionStatus;
import com.encuentratumascota.shelter.model.Adoption;

import java.util.Optional;

public interface IAdoptionService {

    public Optional<Adoption> saveAdoption(Adoption adoption);

    public Optional<Adoption> changeStatusAdoption(Adoption adoption, AdoptionStatus adoptionStatus);

}
