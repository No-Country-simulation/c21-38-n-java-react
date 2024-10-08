package com.encuentratumascota.shelter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encuentratumascota.shelter.model.Pet;

@Repository
public interface IPetRepository extends JpaRepository<Pet, Long> {
	
    public List<Pet> findByActiveStatus(boolean activeStatus); 
}
