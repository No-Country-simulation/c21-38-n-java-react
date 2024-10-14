package com.encuentratumascota.shelter.controller;

import com.encuentratumascota.shelter.business.PetsBusiness;
import com.encuentratumascota.shelter.dto.GeneralResponse;
import com.encuentratumascota.shelter.enums.MessageResponseEnum;
import com.encuentratumascota.shelter.model.Pet;
import com.encuentratumascota.shelter.util.DataUtils;
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
	public GeneralResponse<Pet> getPet(@PathVariable Long id) {
		return this.petsBusiness.getPet(id);
	}

	@PostMapping
	public GeneralResponse<Optional<Pet>> savePet(@RequestBody Pet pet) {
		return petsBusiness.savePet(pet);
	}

	@PutMapping("/{id}")
	public Pet editPet(@PathVariable Long id, @RequestBody Pet pet) {
		this.petsBusiness.editPet(id, pet);
		return pet;
	}

}
