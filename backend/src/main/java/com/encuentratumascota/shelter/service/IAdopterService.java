package com.encuentratumascota.shelter.service;

import com.encuentratumascota.shelter.model.Adopter;

import java.util.Optional;

public interface IAdopterService {

    public Optional<Adopter> saveAdopter(Adopter adopter);

    public Optional<Adopter> getByEmail(String email);

}
