package com.encuentratumascota.shelter.service;

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
    public void savePet(Pet pet) {
        this.petRepository.save(pet);
    }

    @Override
    public void editPet(Long id, Pet pet){
        Pet petToEdit = this.findPet(id);
        this.petRepository.save(pet);
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
