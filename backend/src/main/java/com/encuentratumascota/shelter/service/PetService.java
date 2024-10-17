package com.encuentratumascota.shelter.service;

import com.encuentratumascota.shelter.enums.Breed;
import com.encuentratumascota.shelter.enums.Specie;
import com.encuentratumascota.shelter.model.Pet;
import com.encuentratumascota.shelter.repository.IPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService implements IPetService {

    @Autowired
    private IPetRepository petRepository;

    @Override
    public List<Pet> findPets() {
        return this.petRepository.findByActiveStatus(true);
    }

    @Override
    public Optional<Pet> getPet(Long id) {
        return this.petRepository.findById(id);
    }

    @Override
    public Optional<Pet> savePet(Pet pet) {
        return Optional.of(this.petRepository.save(pet));

    }

    @Override
    public Optional<Pet> editPet(Long id, Pet pet) {
        Optional<Pet> existingPet = this.getPet(id);
        if (existingPet.isEmpty()) {
            return Optional.empty();
        }
        Pet petToUpdate = existingPet.get();
        petToUpdate.setName(pet.getName());
        petToUpdate.setSpecie(Specie.valueOf(pet.getSpecie()));
        petToUpdate.setBreed(Breed.valueOf(pet.getBreed()));
        petToUpdate.setDescriptionBreed(pet.getDescriptionBreed());
        petToUpdate.setAge(pet.getAge());
        petToUpdate.setGender(pet.getGender());
        petToUpdate.setHealthStatus(pet.getHealthStatus());
        petToUpdate.setImageProfile(pet.getImageProfile());
        return this.savePet(petToUpdate);
    }


    @Override
    public Pet findPet(Long id) {
        return this.petRepository.findById(id)
                // no devolver el error (Corregir)
                .orElseThrow(() -> new RuntimeException("No se encontró a la mascota con el Id: " + id + "."));
    }

    @Override
    public void adoptPet(Long id) {
        // asociar a la mascota al futuro duenio
        Pet pet = this.findPet(id);
        pet.setActiveStatus(!pet.isActiveStatus());
        this.petRepository.save(pet);
    }

    // agregar metodo booleano findPet()

}
