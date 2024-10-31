package com.encuentratumascota.shelter.controller;

import com.encuentratumascota.shelter.business.PetsBusiness;
import com.encuentratumascota.shelter.dto.request.AdoptionDTO;
import com.encuentratumascota.shelter.dto.request.PetRequestDTO;
import com.encuentratumascota.shelter.dto.response.DataListPetsDTO;
import com.encuentratumascota.shelter.dto.response.GeneralResponsDTO;
import com.encuentratumascota.shelter.dto.response.PetResponseDTO;
import com.encuentratumascota.shelter.model.Adoption;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('SHELTER')")
    public GeneralResponsDTO<Optional<PetResponseDTO> > savePet(
            HttpServletRequest request, @ModelAttribute PetRequestDTO pet,
            @RequestParam("image") MultipartFile image) {
        return petsBusiness.savePet(request,pet, image);
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
    public GeneralResponsDTO<Adoption> adopt(HttpServletRequest request, @RequestBody AdoptionDTO adoption) {
        return this.petsBusiness.adopt(request, adoption);
    }


}
