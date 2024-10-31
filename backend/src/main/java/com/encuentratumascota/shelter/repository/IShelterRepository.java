package com.encuentratumascota.shelter.repository;

import com.encuentratumascota.shelter.model.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IShelterRepository extends JpaRepository<Shelter, Long> {

    @Query("SELECT s FROM Shelter s JOIN s.user u WHERE u.email = :email")
    Shelter findByUserEmail(@Param("email") String email);
}
