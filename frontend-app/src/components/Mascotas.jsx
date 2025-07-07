import { Mascota } from "./Mascota";
import '../index.css';
import { useState } from "react";

const defaultPets = [
  {
    name: "Firulais",
    age: 3,
    breed: "Labrador",
    descriptionBreed: "Un perro juguetón que ama correr en el parque.",
    imageProfile: "/images/cachorrog1.jpg",
    gender: "Macho",
    healthStatus: "Sano",
    id: 1,
    size: "Mediano",
    specie: "Perro"
  },
  {
    name: "Mishi",
    age: 2,
    breed: "Persa",
    descriptionBreed: "Gato tranquilo que disfruta dormir al sol.",
    imageProfile: "/images/cachorrog2.jpg",
    gender: "Hembra",
    healthStatus: "Sano",
    id: 2,
    size: "Pequeño",
    specie: "Gato"
  },
  {
    name: "Lola",
    age: 1,
    breed: "Cruza",
    descriptionBreed: "Gatita curiosa y muy cariñosa.",
    imageProfile: "/images/cachorrog3.jpg",
    gender: "Hembra",
    healthStatus: "Sana",
    id: 3,
    size: "Pequeño",
    specie: "Conejo"
  },
  {
    name: "Rocky",
    age: 4,
    breed: "Pastor Alemán",
    descriptionBreed: "Perro guardián, muy leal y obediente.",
    imageProfile: "/images/cachorrog5.jpg",
    gender: "Macho",
    healthStatus: "Sano",
    id: 4,
    size: "Grande",
    specie: "Perro"
  }
];

export const Mascotas = () => {
  const [pets] = useState(defaultPets);

  return (
    <div className="flex flex-col pt-[70px] justify-center items-center w-full pb-24">
      <h1 className="text-4xl color-azul font-bold px-20 mb-[73px] text-center">
        Encuentra tu mascota, tenemos amigos que buscan cambiar su vida y la tuya
      </h1>

      {pets.map((pet, index) => (
        <Mascota key={pet.id} pet={pet} reverse={index % 2 === 0} />
      ))}

      <a href="/huellitas" className="text-2xl font-semibold text-orange underline hover:scale-110 transition-all duration-200">
        {`>>>> Conoce muchos más amigos que quieren estar contigo!! <<<<`}
      </a>
    </div>
  );
};
