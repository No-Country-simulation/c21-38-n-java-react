package com.encuentratumascota.shelter.config;

import com.encuentratumascota.shelter.enums.Breed;
import com.encuentratumascota.shelter.enums.Specie;
import com.encuentratumascota.shelter.model.Pet;
import com.encuentratumascota.shelter.repository.IPetRepository;

import java.util.ArrayList;
import java.util.List;

//@Configuration
public class DataInitializer {



    //@Autowired
    private IPetRepository petRepository; // Inyección del repositorio


   //@PostConstruct
    void addData() {



        List<Pet> pets = new ArrayList<>();

        pets.add(new Pet(
                null,  // ID se genera automáticamente
                "Rocky",
                Specie.DOG,
                Breed.DOBERMAN,
                "Perro leal y protector, perfecto para la seguridad del hogar.",
                4,  // Edad
                "M",  // Macho
                "Saludable, con todas las vacunas al día y enérgico.",
                "https://i.ibb.co/827nVMJ/perro-Callejero.jpg",
                "G",  // Grande
                true  // Activo
        ));

        pets.add(new Pet(
                null,
                "Bella",
                Specie.DOG,
                Breed.CRIOLLO,
                "Perra dulce y amigable, ideal para familias con niños.",
                3,  // Edad
                "H",  // Hembra
                "Se encuentra en perfecto estado de salud y muy sociable.",
                "https://i.ibb.co/2KsvTZt/perro10.jpg",
                "M",  // Mediano
                true  // Activo
        ));

        pets.add(new Pet(
                null,
                "Duke",
                Specie.DOG,
                Breed.CRIOLLO,
                "Perro juguetón y cariñoso, excelente compañero.",
                2,  // Edad
                "M",  // Macho
                "Vacunado y desparacitado, lleno de energía.",
                "https://i.ibb.co/yR3ztQR/perro9.jpg",
                "P",  // Pequeño
                true  // Activo
        ));

        pets.add(new Pet(
                null,
                "Sadie",
                Specie.DOG,
                Breed.POODLE,
                "Perra curiosa y activa, siempre lista para la aventura.",
                1,  // Edad
                "H",  // Hembra
                "En buen estado de salud, recién esterilizada.",
                "https://i.ibb.co/vd4hmtH/perro8.jpg",
                "M",  // Mediano
                false  // Inactivo
        ));

        pets.add(new Pet(
                null,
                "Charlie",
                Specie.DOG,
                Breed.POODLE,
                "Perro inteligente y fácil de entrenar, perfecto para familias.",
                5,  // Edad
                "M",  // Macho
                "Vacunado, en excelente condición física.",
                "https://i.ibb.co/GQTfgz5/perro7.jpg",
                "M",  // Mediano
                true  // Activo
        ));

        pets.add(new Pet(
                null,
                "Lola",
                Specie.DOG,
                Breed.CRIOLLO,
                "Perra enérgica y juguetona, amante del frío.",
                2,  // Edad
                "H",  // Hembra
                "Saludable, con mucho amor para dar.",
                "https://i.ibb.co/Px5jnGj/perro6.jpg",
                "G",  // Grande
                true  // Activo
        ));

        pets.add(new Pet(
                null,
                "Milo",
                Specie.DOG,
                Breed.CRIOLLO,
                "Perro valiente y protector, gran compañero.",
                3,  // Edad
                "M",  // Macho
                "Vacunado, con una personalidad encantadora.",
                "https://i.ibb.co/4FfHvnf/perro5.jpg",
                "M",  // Mediano
                true  // Activo
        ));

        pets.add(new Pet(
                null,
                "Coco",
                Specie.DOG,
                Breed.CRIOLLO,
                "Perra dulce y cariñosa, se lleva bien con todos.",
                2,  // Edad
                "H",  // Hembra
                "Esterilizada y en buen estado de salud.",
                "https://i.ibb.co/8NYn7pF/perro4.jpg",
                "P",  // Pequeño
                true  // Activo
        ));

        pets.add(new Pet(
                null,
                "Buddy",
                Specie.DOG,
                Breed.CRIOLLO,
                "Perro fuerte y protector, un excelente guardián.",
                4,  // Edad
                "M",  // Macho
                "En buena forma, con todas sus vacunas al día.",
                "https://i.ibb.co/TBPcFMv/perro3.jpg",
                "G",  // Grande
                true  // Activo
        ));

        pets.add(new Pet(
                null,  // ID se genera automáticamente
                "Maggie",
                Specie.DOG,
                Breed.CRIOLLO,
                "Perra cariñosa y leal, siempre lista para jugar.",
                3,  // Edad
                "H",  // Hembra
                "Saludable y llena de energía.",
                "https://i.ibb.co/jJttTNt/perro2.jpg",
                "G",  // Grande
                true  // Activo
        ));

/// GATOS

        pets.add(new Pet(
                null,
                "Simba",
                Specie.CAT,
                Breed.MAINE_COON,
                "Gato grande y gentil, le encanta jugar y ser acariciado.",
                4,  // Edad
                "M",  // Macho
                "Vacunado y en perfectas condiciones.",
                "https://i.ibb.co/FKgFnb1/gato10.jpg",
                "M",  // Mediano
                true  // Activo
        ));

        pets.add(new Pet(
                null,
                "Nala",
                Specie.CAT,
                Breed.CRIOLLO,
                "Gata juguetona y activa, le gusta escalar y explorar.",
                2,  // Edad
                "H",  // Hembra
                "Saludable y sociable con otros animales.",
                "https://i.ibb.co/4fZfPFV/gato9.jpg",
                "M",  // Mediano
                true  // Activo
        ));

        pets.add(new Pet(
                null,
                "Oliver",
                Specie.CAT,
                Breed.CRIOLLO,
                "Gato tranquilo y cariñoso, perfecto para el hogar.",
                3,  // Edad
                "M",  // Macho
                "En excelente salud y vacunado.",
                "https://i.ibb.co/yXKyB6K/gato8.jpg",
                "M",  // Mediano
                true  // Activo
        ));

        pets.add(new Pet(
                null,
                "Luna",
                Specie.CAT,
                Breed.SPHINX,
                "Gata curiosa y amigable, le encanta la compañía.",
                1,  // Edad
                "H",  // Hembra
                "Vacunada y en buena salud.",
                "https://i.ibb.co/rFB5psG/gato5.jpg",
                "P",  // Pequeño
                true  // Activo
        ));

        pets.add(new Pet(
                null,
                "Leo",
                Specie.CAT,
                Breed.PERSIAN,
                "Gato persa tranquilo, amante del descanso y la comodidad.",
                4,  // Edad
                "M",  // Macho
                "Vacunado y muy cariñoso.",
                "https://i.ibb.co/sV4SMqw/gato4.jpg",
                "M",  // Mediano
                true  // Activo
        ));

        pets.add(new Pet(
                null,
                "Sasha",
                Specie.CAT,
                Breed.ANGORA,
                "Gata dulce con orejas dobladas, siempre está buscando cariño.",
                2,  // Edad
                "H",  // Hembra
                "Saludable y vacunada.",
                "https://i.ibb.co/rscDrLp/gato3.jpg",
                "M",  // Mediano
                true  // Activo
        ));

        pets.add(new Pet(
                null,
                "Cleo",
                Specie.CAT,
                Breed.MAINE_COON,
                "Gata activa y juguetona, siempre lista para la aventura.",
                1,  // Edad
                "H",  // Hembra
                "Esterilizada y en buena salud.",
                "https://i.ibb.co/qdbCW7C/gato2.jpg",
                "M",  // Mediano
                true  // Activo
        ));

        pets.add(new Pet(
                null,
                "Shadow",
                Specie.CAT,
                Breed.CRIOLLO,
                "Gato fuerte y robusto, amante del aire libre.",
                3,  // Edad
                "M",  // Macho
                "Vacunado y saludable.",
                "https://i.ibb.co/279pvsF/cachorrog7.jpg",
                "M",  // Mediano
                true  // Activo
        ));

        pets.add(new Pet(
                null,
                "Misty",
                Specie.CAT,
                Breed.SIAMESE,
                "Gata cariñosa y sociable, le encanta hacer nuevos amigos.",
                2,  // Edad
                "H",  // Hembra
                "Vacunada y muy activa.",
                "https://i.ibb.co/yPfVZKt/cachorrog6.jpg",
                "P",  // Pequeño
                true  // Activo
        ));

        pets.add(new Pet(
                null,
                "Whiskers",
                Specie.CAT,
                Breed.SPHINX,
                "Gato sin pelo, juguetón y lleno de energía.",
                4,  // Edad
                "M",  // Macho
                "Saludable, vacunado y muy sociable.",
                "https://i.ibb.co/jK5M4hD/cachorrog5.jpg",
                "M",  // Mediano
                true  // Activo
        ));
    
    pets.forEach(pet-> petRepository.save(pet));

	}
}
