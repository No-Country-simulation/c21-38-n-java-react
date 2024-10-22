package com.encuentratumascota.shelter.repository;

import com.encuentratumascota.shelter.model.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShelterRepository extends JpaRepository<Shelter, Long> {
}
