package com.encuentratumascota.shelter.service;

import com.encuentratumascota.shelter.model.Pet;

import java.util.List;
import java.util.Optional;

public interface IPetService {

    public List<Pet> findPets();
    public Optional<Pet> getPet(Long id);
    public Optional<Pet> savePet(Pet pet);
    public Optional<Pet> editPet(Long id, Pet pet);
    public Pet findPet(Long id);
    public void adoptPet(Long id);

}
