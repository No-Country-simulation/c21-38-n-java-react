import { useState } from "react";
import { Pet } from "./components/Pet";

export const Pets = () => {
  const defaultPets = [
    {
      name: "Max",
      age: 4,
      breed: "Cruza",
      descriptionBreed: "Amigable, cariñoso y muy juguetón.",
      imageProfile: "/images/perro1.jpg",
      gender: "Macho",
      healthStatus: "Sano",
      id: 1,
      size: "Grande",
      specie: "Perro"
    },
    {
      name: "Luna",
      age: 2,
      breed: "Cruza",
      descriptionBreed: "Gata independiente pero muy mimosa.",
      imageProfile: "/images/gato1.jpg",
      gender: "Hembra",
      healthStatus: "Sana",
      id: 2,
      size: "Pequeño",
      specie: "Gato"
    },
    {
      name: "Toby",
      age: 1,
      breed: "Cruza",
      descriptionBreed: "Curioso y activo. Le encanta explorar.",
      imageProfile: "/images/perro9.jpg",
      gender: "Macho",
      healthStatus: "Sano",
      id: 3,
      size: "Pequeño",
      specie: "Conejo"
    }
  ];

  const [listPets] = useState(defaultPets);

  return (
    <div className="w-full flex flex-col justify-center items-center pb-24">
      <h1 className="text-4xl my-12 text-blue font-bold">Amigos que buscan hogar</h1>
      <div className="flex flex-wrap justify-center items-center gap-8">
        {listPets.map((pet) => (
          <Pet key={pet.id} {...pet} />
        ))}
      </div>
    </div>
  );
};
