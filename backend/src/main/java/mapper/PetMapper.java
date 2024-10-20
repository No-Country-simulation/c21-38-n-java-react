package mapper;

import com.encuentratumascota.shelter.dto.request.PetRequestDTO;
import com.encuentratumascota.shelter.dto.response.PetResponseDTO;
import com.encuentratumascota.shelter.enums.Breed;
import com.encuentratumascota.shelter.enums.Specie;
import com.encuentratumascota.shelter.model.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PetMapper {

    PetMapper INSTANCE = Mappers.getMapper( PetMapper.class );


    @Mapping(source = "specie", target = "specie")
    PetResponseDTO petToPetResponseDTO(Pet pet);

    Pet petRequestDTOToPet(PetRequestDTO petRequestDTO);

    PetResponseDTO petRequestDTOToPetResponseDTO(PetRequestDTO petRequestDTO);

    List<PetResponseDTO> petsToPetResponseDTOs(List<Pet> pets);

    default Specie mapSpecie(String specieName) {
        return Specie.valueOf(specieName.toUpperCase());
    }

    default Breed mapBreed(String breedName) {
        return Breed.valueOf(breedName.toUpperCase());
    }

}
