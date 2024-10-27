package com.encuentratumascota.shelter.repository;

import com.encuentratumascota.shelter.model.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdopterRepository extends JpaRepository<Adopter, Long> {

    Adopter findByUserEmail(String email);

}
