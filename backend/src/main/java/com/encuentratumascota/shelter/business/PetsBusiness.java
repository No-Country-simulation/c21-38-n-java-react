package com.encuentratumascota.shelter.business;

import com.encuentratumascota.shelter.dto.GeneralResponse;
import com.encuentratumascota.shelter.enums.Breed;
import com.encuentratumascota.shelter.enums.MessageResponseEnum;
import com.encuentratumascota.shelter.enums.Specie;
import com.encuentratumascota.shelter.model.Pet;
import com.encuentratumascota.shelter.service.PetService;
import com.encuentratumascota.shelter.util.DataUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PetsBusiness {

    private final PetService petService;

    public PetsBusiness(PetService petService) {
        this.petService = petService;
    }

    public GeneralResponse<List<Pet>> findPets() {
        List<Pet> pets = petService.findPets().stream().filter(Pet::isActiveStatus).collect(Collectors.toList());
        if (!pets.isEmpty()) {
            return DataUtils.buildResponse(MessageResponseEnum.PETS_FOUND_SUCCESSFUL, pets);
        }
        return DataUtils.buildResponse(MessageResponseEnum.PETS_NOT_FOUND, new ArrayList<>());
    }

	public GeneralResponse<Pet> getPet(Long id) {
		Optional<Pet> pet = petService.getPet(id);
		if (pet.isPresent()) {
			return DataUtils.buildResponse(MessageResponseEnum.PET_FOUND_SUCCESSFUL, pet.get());
		}
		return DataUtils.buildResponse(MessageResponseEnum.PET_NOT_FOUND, null);
	}

    public GeneralResponse<Optional<Pet>> savePet(@RequestBody Pet pet) {
        try {
            Optional<Pet> result = this.petService.savePet(pet);
            return DataUtils.buildResponse(MessageResponseEnum.PET_SAVED_SUCCESSFUL, result);
        } catch (Exception e) {
            return DataUtils.buildResponseWithError(MessageResponseEnum.PET_NOT_SAVED, e.getMessage(), Optional.of(pet));
        }
    }

    public GeneralResponse<Optional<Pet>> editPet(Long id, Pet pet) {
        try {
            Optional<Pet> updatedPet = petService.editPet(id, pet);
            if (updatedPet.isEmpty()) {
                return DataUtils.buildResponse(MessageResponseEnum.PET_NOT_FOUND, Optional.empty());
            }
            return DataUtils.buildResponse(MessageResponseEnum.PET_UPDATED_SUCCESSFUL, updatedPet);
        } catch (Exception e) {
            return DataUtils.buildResponseWithError(MessageResponseEnum.PET_NOT_UPDATED, e.getMessage(), Optional.of(pet));
        }
    }

}
