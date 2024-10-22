package com.encuentratumascota.shelter.service;

import com.encuentratumascota.shelter.model.Adopter;

import java.util.List;
import java.util.Optional;

public interface IAdopterService {

    public List<Adopter> findAdopters();
    public Optional<Adopter> getAdopter(Long id);
    public Optional<Adopter> saveAdopter(Adopter adopter);
    public void editAdopter(Long id, Adopter adopter);
}
