package com.encuentratumascota.shelter.config;

import com.encuentratumascota.shelter.enums.Breed;
import com.encuentratumascota.shelter.enums.Specie;
import com.encuentratumascota.shelter.model.Pet;
import com.encuentratumascota.shelter.repository.IPetRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataInitializer {



    @Autowired
    private IPetRepository petRepository; // Inyección del repositorio


    @PostConstruct
    void addData() {
    	
    
    	
    List<Pet> pets = new ArrayList<>();
    
    pets.add(new Pet(
        null,  // ID se genera automáticamente
        "Luna",
        Specie.DOG,
        Breed.BORDER_COLLIE,
        "Es una perra tranquila y amigable, ideal para familias.",
        3,  // Edad
        "H",  // Hembra
        "Se encuentra en buen estado de salud. Todas las vacunas al día.",
        "https://cdn.pixabay.com/photo/2016/02/19/10/00/golden-retriever-1200325_960_720.jpg",
        "G",  // Grande
        true  // Activo
    ));
    
    pets.add(new Pet(
        null,
        "Max",
        Specie.DOG,
        Breed.BORDER_COLLIE,
        "Perro enérgico y curioso, perfecto para hogares activos.",
        2,  // Edad
        "M",  // Macho
        "Buen estado de salud, desparasitado y con todas las vacunas.",
        "https://cdn.pixabay.com/photo/2017/09/25/13/12/dog-2785074_960_720.jpg",
        "M",  // Mediano
        true  // Activo
    ));
    
    pets.add(new Pet(
        null,
        "Nina",
        Specie.CAT,
        Breed.SIAMESE,
        "Gata cariñosa y juguetona. Se lleva bien con otros animales.",
        1,  // Edad
        "H",  // Hembra
        "Esterilizada y vacunada.",
        "https://cdn.pixabay.com/photo/2017/11/09/21/41/siamese-2935038_960_720.jpg",
        "P",  // Pequeño
        true  // Activo
    ));
    
    pets.add(new Pet(
        null,
        "Melina",
        Specie.DOG,
        Breed.BORDER_COLLIE,
        "",  // Descripción vacía
        1,  // Edad
        "H",  // Hembra
        "Está vacunada, y recién separada de la madre.",
        "https://cdn.shopify.com/s/files/1/0486/9396/9064/files/Amanova_come_educare_un_border_collie_480x480.jpg?v=1643197970",
        "M",  // Mediano
        false  // Inactivo
    ));
    
    pets.add(new Pet(
        null,
        "Oliver",
        Specie.CAT,
        Breed.PERSIAN,
        "Gato persa de temperamento tranquilo, ideal para apartamento.",
        4,  // Edad
        "M",  // Macho
        "Vacunado y con buena salud.",
        "https://cdn.pixabay.com/photo/2016/07/10/21/47/cat-1508613_960_720.jpg",
        "M",  // Mediano
        true  // Activo
    ));
    
    pets.forEach(pet-> petRepository.save(pet));
    
    

	}
}
