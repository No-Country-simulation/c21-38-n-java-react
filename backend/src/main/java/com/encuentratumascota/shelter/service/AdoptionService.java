package com.encuentratumascota.shelter.service;

import com.encuentratumascota.shelter.enums.AdoptionStatus;
import com.encuentratumascota.shelter.model.Adoption;
import com.encuentratumascota.shelter.repository.IAdoptionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdoptionService implements IAdoptionService {

    private final IAdoptionRepository iAdoptionRepository;

    public AdoptionService(IAdoptionRepository iAdoptionRepository) {
        this.iAdoptionRepository = iAdoptionRepository;
    }

    @Override
    public Optional<Adoption> saveAdoption(Adoption adoption) {
        return Optional.of(iAdoptionRepository.save(adoption));
    }

    @Override
    public Optional<Adoption> changeStatusAdoption(Adoption adoption, AdoptionStatus adoptionStatus) {
        adoption.setStatus(adoptionStatus);
        return Optional.of(iAdoptionRepository.save(adoption));
    }
}
