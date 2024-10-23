package com.encuentratumascota.shelter.service;

import com.encuentratumascota.shelter.model.Shelter;
import com.encuentratumascota.shelter.repository.IShelterRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShelterService implements IShelterService {

    private final IShelterRepository iShelterRepository;

    public ShelterService(IShelterRepository iShelterRepository) {
        this.iShelterRepository = iShelterRepository;
    }

    @Override
    public Optional<Shelter> saveShelter(Shelter shelter) {
        return Optional.of(iShelterRepository.save(shelter));
    }
}
