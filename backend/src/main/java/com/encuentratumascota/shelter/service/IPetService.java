package com.encuentratumascota.shelter.service;

import com.encuentratumascota.shelter.model.Pet;

import java.util.List;
import java.util.Optional;

public interface IPetService {

    public List<Pet> findActivePets();
    public Optional<Pet> savePet(Pet pet);
    public Optional<Pet> findPet(Long id);
    public List<Pet> findActiveByShelterId(Long shelterId);

}
