package com.encuentratumascota.shelter.business;

import com.encuentratumascota.shelter.dto.request.AdoptionDTO;
import com.encuentratumascota.shelter.dto.request.PetRequestDTO;
import com.encuentratumascota.shelter.dto.response.DataListPetsDTO;
import com.encuentratumascota.shelter.dto.response.GeneralResponsDTO;
import com.encuentratumascota.shelter.dto.response.PetResponseDTO;
import com.encuentratumascota.shelter.enums.AdoptionStatus;
import com.encuentratumascota.shelter.enums.MessageResponseEnum;
import com.encuentratumascota.shelter.enums.UserTypeImage;
import com.encuentratumascota.shelter.model.*;
import com.encuentratumascota.shelter.service.*;
import com.encuentratumascota.shelter.util.DataUtils;
import com.encuentratumascota.shelter.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import mapper.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class PetsBusiness {

    private final PetService petService;
    private final PetMapper petMapper;
    private final ImageUploadService imageUploadService;
    private final ImageDebuggingService imageDebuggingService;
    private final AdopterService adopterService;
    private final ShelterService shelterService;
    private final AdoptionService adoptionService;

    @Autowired
    private JwtUtil jwtUtil;

    public PetsBusiness(PetService petService, PetMapper petMapper, ImageUploadService imageUploadService, ImageDebuggingService imageDebuggingService, AdopterService adopterService, ShelterService shelterService, AdoptionService adoptionService) {
        this.petService = petService;
        this.petMapper = petMapper;
        this.imageUploadService = imageUploadService;
        this.imageDebuggingService = imageDebuggingService;
        this.adopterService = adopterService;
        this.shelterService = shelterService;
        this.adoptionService = adoptionService;
    }

    public GeneralResponsDTO<List<PetResponseDTO>> findActivePets() {
        List<String> errors = new ArrayList<>();
        List<Pet> activePets = petService.findActivePets();
        if (!activePets.isEmpty()) {
            return DataUtils.buildResponse(MessageResponseEnum.PETS_FOUND_SUCCESSFUL, petMapper.petsToPetResponseDTOs(activePets), errors);
        }
        return DataUtils.buildResponse(MessageResponseEnum.PETS_NOT_FOUND, new ArrayList<>(), errors);
    }

    public GeneralResponsDTO<List<PetResponseDTO>> findActivePetsByShelterId(HttpServletRequest request) {
        List<String> errors = new ArrayList<>();
        List<Pet> activePets = new ArrayList<>();
        String authorizationHeader = request.getHeader("Authorization");
        try {
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String token = request.getHeader("Authorization").substring(7);
                String username = jwtUtil.getUsernameFromToken(token);
                Optional<Shelter> shelter = shelterService.getByEmail(username);
                if (shelter.isEmpty()) {
                    errors.add("El refugio no fue encontrado para efectuar la consulta");
                    return DataUtils.buildResponse(MessageResponseEnum.PET_NOT_SAVED, null, errors);
                }
                activePets = petService.findActiveByShelterId(shelter.get().getId());
            }
            if (!activePets.isEmpty()) {
                return DataUtils.buildResponse(MessageResponseEnum.PETS_FOUND_SUCCESSFUL, petMapper.petsToPetResponseDTOs(activePets), errors);
            }
            return DataUtils.buildResponse(MessageResponseEnum.PETS_NOT_FOUND, new ArrayList<>(), errors);
        }catch(Exception e){
            errors.add(e.getMessage());
            return DataUtils.buildResponse(MessageResponseEnum.PETS_NOT_FOUND, new ArrayList<>(), errors);
        }
    }

    public GeneralResponsDTO<Optional<PetResponseDTO>> savePet(HttpServletRequest request, PetRequestDTO petRequest, MultipartFile image) {
        Optional<PetResponseDTO> petResponse = Optional.of(petMapper.petRequestDTOToPetResponseDTO(petRequest));
        List<String> errors = new ArrayList<>();
        String authorizationHeader = request.getHeader("Authorization");
        Pet pet = petMapper.petRequestDTOToPet(petRequest);
        try {
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String token = request.getHeader("Authorization").substring(7);
                String username = jwtUtil.getUsernameFromToken(token);
                Optional<Shelter> shelter = shelterService.getByEmail(username);
                if (shelter.isEmpty()) {
                    errors.add("El refugio no fue encontrado para efectuar el registro");
                    return DataUtils.buildResponse(MessageResponseEnum.PET_NOT_SAVED, null, errors);
                }


                pet.setShelterId(shelter.get().getId());
            }
            this.saveImage(pet, image);
            pet.setActiveStatus(true);
            Optional<Pet> savedPet = this.petService.savePet(pet);
            return savedPet.map(p -> DataUtils.buildResponse(MessageResponseEnum.PET_SAVED_SUCCESSFUL, Optional.of(petMapper.petToPetResponseDTO(p)), errors)).orElseGet(() -> DataUtils.buildResponse(MessageResponseEnum.PET_NOT_SAVED, Optional.empty(), errors));
        } catch (Exception e) {
            errors.add(e.getMessage());
            return DataUtils.buildResponseWithError(MessageResponseEnum.PET_NOT_SAVED, e.getMessage(), petResponse);
        }
    }


    public GeneralResponsDTO<Optional<PetResponseDTO>> editPet(Long id, PetRequestDTO petRequest, MultipartFile image) {
        List<String> errors = new ArrayList<>();
        try {
            Optional<Pet> petToEdit = petService.findPet(id);
            if (petToEdit.isPresent()) {
                Pet pet = petMapper.petRequestDTOToPet(petRequest);
                pet.setId(petToEdit.get().getId());
                pet.setActiveStatus(true);
                pet.setImageName(petToEdit.get().getImageName());
                pet.setImageProfile(petToEdit.get().getImageProfile());
                if (!image.isEmpty()) {
                    this.updateImage(pet, image);
                }
                Optional<Pet> updatedPet = petService.savePet(pet);
                return updatedPet.map(p -> DataUtils.buildResponse(MessageResponseEnum.PET_UPDATED_SUCCESSFUL, Optional.of(petMapper.petToPetResponseDTO(p)), errors)).orElseGet(() -> DataUtils.buildResponse(MessageResponseEnum.PET_NOT_UPDATED, Optional.empty(), errors));
            }
            return DataUtils.buildResponse(MessageResponseEnum.PET_NOT_FOUND, Optional.empty(), errors);
        } catch (Exception e) {
            errors.add(e.getMessage());
            return DataUtils.buildResponseWithError(MessageResponseEnum.PET_NOT_UPDATED, e.getMessage(), Optional.empty());
        }
    }


    public GeneralResponsDTO<DataListPetsDTO> getListDataPets() {
        List<String> errors = new ArrayList<>();
        DataListPetsDTO result = new DataListPetsDTO();
        result.setBreeds(DataUtils.getAllBreedData());
        result.setSpecies(DataUtils.getAllSpecieData());
        result.setSize(DataUtils.generateListDataSize());
        result.setGender(DataUtils.generateListDataGender());
        return DataUtils.buildResponse(MessageResponseEnum.LISTS_DATA_PETS_FOUND_SUCCESSFUL, result, errors);
    }

    private void saveImageDebugging(String url, String name, String userTypeImage) {
        ImageDebugging imageDebugging = new ImageDebugging();
        imageDebugging.setImageName(name);
        imageDebugging.setUrlImage(url);
        imageDebugging.setType(userTypeImage);
        imageDebuggingService.saveImageDebugging(imageDebugging);
    }

    private void saveImage(Pet pet, MultipartFile image) throws IOException {
        String code = DataUtils.generateCode();
        String name = code + "-" + pet.getName();
        File tempFile = File.createTempFile(code, name);
        image.transferTo(tempFile);
        pet.setImageProfile(imageUploadService.uploadImage(tempFile, name));
        pet.setImageName(name);
        tempFile.delete();
    }

    private void updateImage(Pet pet, MultipartFile image) throws IOException {
        String code = DataUtils.generateCode();
        String name = code + "-" + pet.getName();
        File tempFile = File.createTempFile(code, code);
        image.transferTo(tempFile);
        String url = imageUploadService.uploadImage(tempFile, name);
        if (!url.equals(pet.getImageProfile())) {
            pet.setImageName(name);
            pet.setImageProfile(url);
            this.saveImageDebugging(url, pet.getImageName(), UserTypeImage.PET.name());
        }
        tempFile.delete();
    }

    public GeneralResponsDTO<List<Adoption>> shelterAdoptions(HttpServletRequest request) {
        List<String> errors = new ArrayList<>();
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = request.getHeader("Authorization").substring(7);
            String username = jwtUtil.getUsernameFromToken(token);
            Optional<Shelter> shelter = shelterService.getByEmail(username);
            if (shelter.isEmpty()) {
                errors.add("El refugio NO está registrado en el sistema");
                return DataUtils.buildResponse(MessageResponseEnum.ADOPTIONS_NOT_FOUND, null, errors);
            }
            List<Adoption> result = adoptionService.getAdoptionsByShelterId(shelter.get().getId());
            if (result.isEmpty()) {
                errors.add("El usuario no tiene adopciones asociadas");
            }
            return DataUtils.buildResponse(MessageResponseEnum.ADOPTIONS_SUCCESSFUL, result, errors);
        }
        return DataUtils.buildResponse(MessageResponseEnum.ADOPTIONS_NOT_FOUND, new ArrayList<>(), errors);

    }


    public GeneralResponsDTO<List<Adoption>> adopterAdoptions(HttpServletRequest request) {
        List<String> errors = new ArrayList<>();
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = request.getHeader("Authorization").substring(7);
            String username = jwtUtil.getUsernameFromToken(token);
            List<Adoption> result = adoptionService.getAdoptionsByAdopterEmail(username);
            if (result.isEmpty()) {
                errors.add("El usuario no tiene adopciones asociadas");
            }
            return DataUtils.buildResponse(MessageResponseEnum.ADOPTIONS_SUCCESSFUL, result, errors);
        }
        return DataUtils.buildResponse(MessageResponseEnum.ADOPTIONS_NOT_FOUND, new ArrayList<>(), errors);

    }


    public GeneralResponsDTO<Adoption> adopt(HttpServletRequest request, AdoptionDTO adoptionDTO) {
        List<String> errors = new ArrayList<>();
        Adoption adoption = new Adoption();
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = request.getHeader("Authorization").substring(7);
            String username = jwtUtil.getUsernameFromToken(token);
            Optional<Adopter> adopter = adopterService.getByEmail(username);
            Optional<Pet> pet = petService.findPet(adoptionDTO.getPetId());
            if (adopter.isEmpty()) {
                errors.add("El adoptante no está registrado en el sistema");
            }
            if (pet.isEmpty()) {
                errors.add("La mascota no está registrada en el sistema");
                return DataUtils.buildResponse(MessageResponseEnum.ERROR_ADOPTION, null, errors);
            }
            adoption.setStatus(AdoptionStatus.IN_PROCESS);
            adoption.setDescription(adoptionDTO.getDescription());
            adoption.setPet(pet.get());
            adoption.setAdopter(adopter.get());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String fechaActual = formatter.format(new Date());
            adoption.setAdoptionDate(fechaActual);
            Optional<Adoption> result = adoptionService.saveAdoption(adoption);
            if (result.isEmpty()) {
                return DataUtils.buildResponse(MessageResponseEnum.ADOPTION_NOT_SAVED, adoption, errors);
            }
            return DataUtils.buildResponse(MessageResponseEnum.ADOPTION_REGISTER_SUCCESSFUL, result.get(), errors);
        }
        return DataUtils.buildResponse(MessageResponseEnum.ADOPTION_NOT_SAVED, adoption, errors);
    }

    public GeneralResponsDTO<Adoption> updateAdoption(HttpServletRequest request, Long id,AdoptionStatus adoptionStatus) {
        List<String> errors = new ArrayList<>();
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = request.getHeader("Authorization").substring(7);
            String username = jwtUtil.getUsernameFromToken(token);
            Optional<Shelter> shelter = shelterService.getByEmail(username);
            if (shelter.isEmpty()) {
                errors.add("El refugio NO está registrado en el sistema");
                return DataUtils.buildResponse(MessageResponseEnum.ADOPTION_NOT_UPDATED, null, errors);
            }
            Optional<Adoption> adoption = adoptionService.getAdoptionsById(id);
            if (adoption.isEmpty()) {
                errors.add("El registro de la adopción NO está registrado en el sistema");
                return DataUtils.buildResponse(MessageResponseEnum.ADOPTION_NOT_UPDATED, null, errors);

            }
            Optional<Adoption> result = adoptionService.changeStatusAdoption(adoption.get(),adoptionStatus);
            if (result.isEmpty()) {
                return DataUtils.buildResponse(MessageResponseEnum.ADOPTION_NOT_UPDATED, null, errors);
            }
            return DataUtils.buildResponse(MessageResponseEnum.ADOPTION_UPDATED_SUCCESSFUL, result.get(), errors);
        }
        return DataUtils.buildResponse(MessageResponseEnum.ADOPTION_NOT_UPDATED, null, errors);
    }
}
