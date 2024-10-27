package com.encuentratumascota.shelter.service;

import com.encuentratumascota.shelter.model.Adopter;
import com.encuentratumascota.shelter.repository.IAdopterRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdopterService implements IAdopterService {

    private final IAdopterRepository iAdopterRepository;

    public AdopterService(IAdopterRepository iAdopterRepository) {
        this.iAdopterRepository = iAdopterRepository;

    }

    @Override
    public Optional<Adopter> saveAdopter(Adopter adopter) {
        return Optional.of(iAdopterRepository.save(adopter));
    }

    @Override
    public Optional<Adopter> getByEmail(String email) {
        return Optional.of(iAdopterRepository.findByUserEmail(email));
    }

}
