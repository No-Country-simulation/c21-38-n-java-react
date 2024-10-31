package com.encuentratumascota.shelter.controller;

import com.encuentratumascota.shelter.business.PetsBusiness;
import com.encuentratumascota.shelter.dto.response.DataListPetsDTO;
import com.encuentratumascota.shelter.dto.response.GeneralResponsDTO;
import com.encuentratumascota.shelter.dto.response.PetResponseDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "*")
public class PublicController {

    private final PetsBusiness petsBusiness;

    public PublicController(PetsBusiness petsBusiness) {
        this.petsBusiness = petsBusiness;
    }

    @GetMapping("/pets")
    public GeneralResponsDTO<List<PetResponseDTO>> getPets() {
        return this.petsBusiness.findActivePets();
    }

    @GetMapping("/lists")
    public GeneralResponsDTO<DataListPetsDTO> getLists() {
        return this.petsBusiness.getListDataPets();
    }


}
