package com.encuentratumascota.shelter.service;

import com.encuentratumascota.shelter.model.Shelter;

import java.util.Optional;

public interface IShelterService {


    public Optional<Shelter> saveShelter(Shelter shelter);

    public Optional<Shelter> getByEmail(String email);


}
