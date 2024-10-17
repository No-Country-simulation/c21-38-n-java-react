package com.encuentratumascota.shelter.business;

import com.encuentratumascota.shelter.dto.DataListPetsDTO;
import com.encuentratumascota.shelter.dto.GeneralResponsDTO;
import com.encuentratumascota.shelter.enums.Breed;
import com.encuentratumascota.shelter.enums.Breed;
import com.encuentratumascota.shelter.enums.MessageResponseEnum;
import com.encuentratumascota.shelter.enums.Specie;
import com.encuentratumascota.shelter.enums.Specie;
import com.encuentratumascota.shelter.model.Pet;
import com.encuentratumascota.shelter.service.ImageUploadService;
import com.encuentratumascota.shelter.service.PetService;
import com.encuentratumascota.shelter.util.DataUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PetsBusiness {

    private final PetService petService;
    private final ImageUploadService imageUploadService;

    public PetsBusiness(PetService petService,ImageUploadService imageUploadService) {
        this.petService = petService;
        this.imageUploadService = imageUploadService;
    }

    public GeneralResponsDTO<List<Pet>> findPets() {
        List<Pet> pets = petService.findPets().stream().filter(Pet::isActiveStatus).collect(Collectors.toList());
        if (!pets.isEmpty()) {
            return DataUtils.buildResponse(MessageResponseEnum.PETS_FOUND_SUCCESSFUL, pets);
        }
        return DataUtils.buildResponse(MessageResponseEnum.PETS_NOT_FOUND, new ArrayList<>());
    }

	public GeneralResponsDTO<Pet> getPet(Long id) {
		Optional<Pet> pet = petService.getPet(id);
		if (pet.isPresent()) {
			return DataUtils.buildResponse(MessageResponseEnum.PET_FOUND_SUCCESSFUL, pet.get());
		}
		return DataUtils.buildResponse(MessageResponseEnum.PET_NOT_FOUND, null);
	}

    public GeneralResponsDTO<Optional<Pet>> savePet(Pet pet,MultipartFile image) {
        try {
            String code = DataUtils.generateCode();
            String name = code + "-" + pet.getName();
            System.out.println("El nombre es " + name);

            File tempFile = File.createTempFile(code,code);
            image.transferTo(tempFile);
            String urlImg = imageUploadService.uploadImage(tempFile,name);
            tempFile.delete();
            pet.setImageProfile(urlImg);
            pet.setActiveStatus(true);
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


    public GeneralResponsDTO<DataListPetsDTO> getLists() {
        DataListPetsDTO result = new DataListPetsDTO();
        result.setBreeds(Breed.getAllBreedData());
        result.setSpecies(Specie.getAllSpecieData());
        result.setSize(DataUtils.generateListDataSize());
        result.setGender(DataUtils.generateListDataGender());
        return DataUtils.buildResponse(MessageResponseEnum.LISTS_DATA_PETS_FOUND_SUCESSFUL, result);
    }
}
