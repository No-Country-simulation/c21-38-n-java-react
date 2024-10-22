package com.encuentratumascota.shelter.service;

import com.encuentratumascota.shelter.model.Shelter;

import java.util.List;
import java.util.Optional;

public interface IShelterService {

    public List<Shelter> findShelters();
    public Optional<Shelter> getShelter(Long id);
    public Optional<Shelter> saveShelter(Shelter shelter);
    public void editShelter(Long id, Shelter shelter);

}
