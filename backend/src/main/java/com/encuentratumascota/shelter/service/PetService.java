package com.encuentratumascota.shelter.service;

import com.encuentratumascota.shelter.model.Pet;
import com.encuentratumascota.shelter.repository.IPetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService implements IPetService {

    private final IPetRepository petRepository;

    public PetService(IPetRepository petRepository) {
        this.petRepository = petRepository;

    }

    @Override
    public List<Pet> findActivePets() {
        return petRepository.findByActiveStatus(true);
    }


    @Override
    public Optional<Pet> savePet(Pet pet) {
        return Optional.of(this.petRepository.save(pet));
    }


    @Override
    public Optional<Pet> findPet(Long id) {
        return petRepository.findById(id);
    }


}
