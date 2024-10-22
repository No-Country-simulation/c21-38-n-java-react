package com.encuentratumascota.shelter.repository;

import com.encuentratumascota.shelter.model.ImageDebugging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageDebuggingRepository extends JpaRepository<ImageDebugging, Long> {
}
