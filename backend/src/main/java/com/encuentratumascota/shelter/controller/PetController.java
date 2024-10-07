package com.encuentratumascota.shelter.controller;

import com.encuentratumascota.shelter.model.Pet;
import com.encuentratumascota.shelter.service.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    private IPetService petService;

    @GetMapping
    public List<Pet> getPets(){
        return this.petService.findPets();
    }

    @GetMapping("/{id}")
    public Optional<Pet> getPet(@PathVariable Long id){
        return this.petService.getPet(id);
    }

    @PostMapping
    public Pet savePet(@RequestBody Pet pet){
        this.petService.savePet(pet);
        return pet;
    }

    @PutMapping("/{id}")
    public Pet editPet(@PathVariable Long id, @RequestBody Pet pet){
        this.petService.editPet(id, pet);
        return pet;
    }

}
