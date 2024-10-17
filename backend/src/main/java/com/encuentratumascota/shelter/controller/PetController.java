package com.encuentratumascota.shelter.controller;

import com.encuentratumascota.shelter.business.PetsBusiness;
import com.encuentratumascota.shelter.dto.DataListPetsDTO;
import com.encuentratumascota.shelter.dto.GeneralResponsDTO;
import com.encuentratumascota.shelter.model.Pet;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
	public GeneralResponsDTO<List<Pet>> getPets() {
		return this.petsBusiness.findPets();
	}

	@GetMapping("/{id}")
	public GeneralResponsDTO<Pet> getPet(@PathVariable Long id) {
		return this.petsBusiness.getPet(id);
	}

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public GeneralResponsDTO<Optional<Pet>> savePet(
			@ModelAttribute Pet pet,
			@RequestParam("image") MultipartFile image) {
		return petsBusiness.savePet(pet, image);
	}

	@PutMapping("/{id}")
	public GeneralResponse<Optional<Pet>> editPet(@PathVariable Long id, @RequestBody Pet pet) {
		return petsBusiness.editPet(id, pet);
	}

	@GetMapping("/lists")
	public GeneralResponsDTO<DataListPetsDTO> getLists() {
		return this.petsBusiness.getLists();
	}

}
