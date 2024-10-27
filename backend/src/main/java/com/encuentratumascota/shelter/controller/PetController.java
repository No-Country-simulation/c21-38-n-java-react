package com.encuentratumascota.shelter.controller;

import com.encuentratumascota.shelter.business.PetsBusiness;
import com.encuentratumascota.shelter.dto.request.PetRequestDTO;
import com.encuentratumascota.shelter.dto.response.DataListPetsDTO;
import com.encuentratumascota.shelter.dto.response.GeneralResponsDTO;
import com.encuentratumascota.shelter.dto.response.PetResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
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
    public GeneralResponsDTO<List<PetResponseDTO>> getPets() {
        return this.petsBusiness.findActivePets();
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public GeneralResponsDTO<Optional<PetResponseDTO> > savePet(
            @ModelAttribute PetRequestDTO pet,
            @RequestParam("image") MultipartFile image) {
        return petsBusiness.savePet(pet, image);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public GeneralResponsDTO<Optional<PetResponseDTO>> editPet(
            @PathVariable Long id,
            @ModelAttribute PetRequestDTO pet,
            @RequestParam("image") MultipartFile image) {
        return petsBusiness.editPet(id, pet, image);
    }


    @GetMapping("/lists")
    public GeneralResponsDTO<DataListPetsDTO> getLists() {
        return this.petsBusiness.getListDataPets();
    }

    @PostMapping("/adopt")
    public GeneralResponsDTO<String> adopt(HttpServletRequest request, Long petId) {
        return this.petsBusiness.adopt(request, petId);
    }


}
