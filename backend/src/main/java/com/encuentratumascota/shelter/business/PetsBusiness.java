package com.encuentratumascota.shelter.business;

import com.encuentratumascota.shelter.dto.request.PetRequestDTO;
import com.encuentratumascota.shelter.dto.response.DataListPetsDTO;
import com.encuentratumascota.shelter.dto.response.GeneralResponsDTO;
import com.encuentratumascota.shelter.enums.Breed;
import com.encuentratumascota.shelter.dto.response.PetResponseDTO;
import com.encuentratumascota.shelter.enums.MessageResponseEnum;
import com.encuentratumascota.shelter.enums.Specie;
import com.encuentratumascota.shelter.model.Pet;
import com.encuentratumascota.shelter.service.ImageDebuggingService;
import com.encuentratumascota.shelter.service.ImageUploadService;
import com.encuentratumascota.shelter.service.PetService;
import com.encuentratumascota.shelter.util.DataUtils;
import mapper.PetMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PetsBusiness {

    private final PetService petService;
    private final PetMapper petMapper;
    private final ImageUploadService imageUploadService;
    private final ImageDebuggingService imageDebuggingService;


    public PetsBusiness(PetService petService, PetMapper petMapper, ImageUploadService imageUploadService, ImageDebuggingService imageDebuggingService) {
        this.petService = petService;
        this.petMapper = petMapper;
        this.imageUploadService = imageUploadService;
        this.imageDebuggingService = imageDebuggingService;
    }

    public GeneralResponsDTO<List<PetResponseDTO>> findActivePets() {
        List<Pet> activePets = petService.findActivePets();
        if (!activePets.isEmpty()) {
            return DataUtils.buildResponse(MessageResponseEnum.PETS_FOUND_SUCCESSFUL, petMapper.petsToPetResponseDTOs(activePets));
        }
        return DataUtils.buildResponse(MessageResponseEnum.PETS_NOT_FOUND, new ArrayList<>());
    }

    public GeneralResponsDTO<Optional<PetResponseDTO>> savePet(PetRequestDTO petRequest, MultipartFile image) {
        Optional<PetResponseDTO> petResponse =  Optional.of(petMapper.petRequestDTOToPetResponseDTO(petRequest));
        try {
            Pet pet = petMapper.petRequestDTOToPet(petRequest);
            this.saveImage(pet,image);
            pet.setActiveStatus(true);
            Optional<Pet> savedPet = this.petService.savePet(pet);
            return savedPet.map(p -> DataUtils.buildResponse(MessageResponseEnum.PET_SAVED_SUCCESSFUL, Optional.of(petMapper.petToPetResponseDTO(p))))
                    .orElseGet(() -> DataUtils.buildResponse(MessageResponseEnum.PET_NOT_SAVED, Optional.empty()));
        } catch (Exception e) {
            return DataUtils.buildResponseWithError(MessageResponseEnum.PET_NOT_SAVED, e.getMessage(), petResponse);
        }
    }


    public GeneralResponsDTO<Optional<PetResponseDTO>> editPet(Long id, PetRequestDTO petRequest, MultipartFile image) {
        try {
            Optional<Pet> petToEdit = petService.findPet(id);
            if (petToEdit.isPresent()) {
                Pet pet = petMapper.petRequestDTOToPet(petRequest);
                pet.setId(petToEdit.get().getId());
                pet.setActiveStatus(true);
                pet.setImageName(petToEdit.get().getImageName());
                pet.setImageProfile(petToEdit.get().getImageProfile());
                if(!image.isEmpty()){
                    this.updateImage(pet, image);
                }
                Optional<Pet> updatedPet = petService.savePet(pet);
                return updatedPet.map(p -> DataUtils.buildResponse(MessageResponseEnum.PET_UPDATED_SUCCESSFUL, Optional.of(petMapper.petToPetResponseDTO(p))))
                        .orElseGet(() -> DataUtils.buildResponse(MessageResponseEnum.PET_NOT_UPDATED, Optional.empty()));
            }
            return DataUtils.buildResponse(MessageResponseEnum.PET_NOT_FOUND, Optional.empty());
        } catch (Exception e) {
            return DataUtils.buildResponseWithError(MessageResponseEnum.PET_NOT_UPDATED, e.getMessage(), Optional.empty());
        }
    }


    public GeneralResponsDTO<DataListPetsDTO> getListDataPets() {
        DataListPetsDTO result = new DataListPetsDTO();
        result.setBreeds(DataUtils.getAllBreedData());
        result.setSpecies(DataUtils.getAllSpecieData());
        result.setSize(DataUtils.generateListDataSize());
        result.setGender(DataUtils.generateListDataGender());
        return DataUtils.buildResponse(MessageResponseEnum.LISTS_DATA_PETS_FOUND_SUCESSFUL, result);
    }

    private void saveImageDebugging(String url, String name, String userTypeImage){
        ImageDebugging imageDebugging = new ImageDebugging();
        imageDebugging.setImageName(name);
        imageDebugging.setUrlImage(url);
        imageDebugging.setType(userTypeImage);
        imageDebuggingService.saveImageDebugging(imageDebugging);
    }

    private void saveImage(Pet pet, MultipartFile image) throws IOException {
        String code = DataUtils.generateCode();
        String name = code + "-" + pet.getName();
        File tempFile = File.createTempFile(code,name);
        image.transferTo(tempFile);
        pet.setImageProfile(imageUploadService.uploadImage(tempFile,name));
        pet.setImageName(name);
        tempFile.delete();
    }

    private void updateImage(Pet pet, MultipartFile image) throws IOException {
        String code = DataUtils.generateCode();
        String name = code + "-" + pet.getName();
        File tempFile = File.createTempFile(code,code);
        image.transferTo(tempFile);
        String url = imageUploadService.uploadImage(tempFile,name);
        if(!url.equals(pet.getImageProfile())){
            pet.setImageName(name);
            pet.setImageProfile(url);
            this.saveImageDebugging(url,pet.getImageName(),UserTypeImage.PET.name());
        }
        tempFile.delete();
    }

}
