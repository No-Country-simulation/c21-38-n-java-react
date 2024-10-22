package com.encuentratumascota.shelter.repository;

import com.encuentratumascota.shelter.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPetRepository extends JpaRepository<Pet, Long> {
	
    public List<Pet> findByActiveStatus(boolean activeStatus);
}
