package com.encuentratumascota.shelter.controller;

import com.encuentratumascota.shelter.business.PetsBusiness;
import com.encuentratumascota.shelter.dto.GeneralResponse;
import com.encuentratumascota.shelter.model.Pet;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pets")
public class PetController {

	private final PetsBusiness petsBusiness;

	public PetController(PetsBusiness petsBusiness) {
		this.petsBusiness = petsBusiness;
	}

	@GetMapping
	public  GeneralResponse<List<Pet>> getPets() {
		return this.petsBusiness.findPets();
	}

	@GetMapping("/{id}")
	public Optional<Pet> getPet(@PathVariable Long id) {
		return this.petsBusiness.getPet(id);
	}

	@PostMapping
	public Pet savePet(@RequestBody Pet pet) {
		this.petsBusiness.savePet(pet);
		return pet;
	}

	@PutMapping("/{id}")
	public Pet editPet(@PathVariable Long id, @RequestBody Pet pet) {
		this.petsBusiness.editPet(id, pet);
		return pet;
	}

}
