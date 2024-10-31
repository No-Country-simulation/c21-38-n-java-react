package com.encuentratumascota.shelter.repository;

import com.encuentratumascota.shelter.model.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdoptionRepository extends JpaRepository<Adoption, Long> {

}
