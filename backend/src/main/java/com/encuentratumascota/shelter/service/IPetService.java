package com.encuentratumascota.shelter.service;

import java.util.List;
import java.util.Optional;

import com.encuentratumascota.shelter.model.Pet;

public interface IPetService {

    public List<Pet> findPets();
    public Optional<Pet> getPet(Long id);
    public void savePet(Pet pet);
    public void editPet(Long id, Pet pet);
    public Pet findPet(Long id);
    public void adoptPet(Long id);

}
