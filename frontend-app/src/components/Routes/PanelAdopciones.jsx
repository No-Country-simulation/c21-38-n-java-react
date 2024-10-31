import { useState } from "react";
import { Nav } from "../Nav";

export const PanelAdopciones = () => {
    const slides = [
        "./../../../public/images/cachorrog1.jpg",
        "./../../../public/images/cachorrog2.jpg",
        "./../../../public/images/cachorrog3.jpg",
        "./../../../public/images/cachorrog5.jpg",
    ];

    const infoSlides = ["Sanchito", "Luciano", "Garritas", "Pepon"];

    const InfoExtra = [
        {
            Especie: "Gato",
            Raza: "Callejero",
            Edad: 3,
            Sexo: "Hembra",
            Salud: "Se encuentra en buen estado de salud. Todas las vacunas al día.",
            Tamaño: "Pequeño"
        },
        {
            Especie: "Gato",
            Raza: "Callejero",
            Edad: 3,
            Sexo: "Hembra",
            Salud: "Se encuentra en buen estado de salud. Todas las vacunas al día.",
            Tamaño: "Pequeño"
        },
        {
            Especie: "Gato",
            Raza: "Callejero",
            Edad: 3,
            Sexo: "Hembra",
            Salud: "Se encuentra en buen estado de salud. Todas las vacunas al día.",
            Tamaño: "Pequeño"
        },
        {
            Especie: "Gato",
            Raza: "Callejero",
            Edad: 3,
            Sexo: "Hembra",
            Salud: "Se encuentra en buen estado de salud. Todas las vacunas al día.",
            Tamaño: "Pequeño"
        }
    ];

    const infoAdoptante = [
        {
            name: "Nombre de Usuario 1",
            lastName: "Espinoza",
            email: "usuario1@gmail.com",
            country: "Dirección 7756",
            cellphoneNumber: "2236979758",
            birthDate: "2024-10-24",
            civilStatus: "SINGLE",
            actualPets: 0,
            familyMembers: 0,
            adoptionReason: "Amo los animales",
            dailyTimeAvailable: 4,
            houseType: "APARTMENT",
            houseExtension: 20,
            identificationType: "DNI",
            identificationNumber: 4056987,
            city: "Mar del Plata",
        },
        {
            name: "Nombre de Usuario 1",
            lastName: "Espinoza",
            email: "usuario1@gmail.com",
            country: "Dirección 7756",
            cellphoneNumber: "2236979758",
            birthDate: "2024-10-24",
            civilStatus: "SINGLE",
            actualPets: 0,
            familyMembers: 0,
            adoptionReason: "Amo los animales",
            dailyTimeAvailable: 4,
            houseType: "APARTMENT",
            houseExtension: 20,
            identificationType: "DNI",
            identificationNumber: 4056987,
            city: "Mar del Plata",
        },
        {
            name: "Nombre de Usuario 1",
            lastName: "Espinoza",
            email: "usuario1@gmail.com",
            country: "Dirección 7756",
            cellphoneNumber: "2236979758",
            birthDate: "2024-10-24",
            civilStatus: "SINGLE",
            actualPets: 0,
            familyMembers: 0,
            adoptionReason: "Amo los animales",
            dailyTimeAvailable: 4,
            houseType: "APARTMENT",
            houseExtension: 20,
            identificationType: "DNI",
            identificationNumber: 4056987,
            city: "Mar del Plata",
        },
        {
            name: "Nombre de Usuario 1",
            lastName: "Espinoza",
            email: "usuario1@gmail.com",
            country: "Dirección 7756",
            cellphoneNumber: "2236979758",
            birthDate: "2024-10-24",
            civilStatus: "SINGLE",
            actualPets: 0,
            familyMembers: 0,
            adoptionReason: "Amo los animales",
            dailyTimeAvailable: 4,
            houseType: "APARTMENT",
            houseExtension: 20,
            identificationType: "DNI",
            identificationNumber: 4056987,
            city: "Mar del Plata",
        }
    ];

    const [hoveredIndex, setHoveredIndex] = useState(null);
    const [visibleCards, setVisibleCards] = useState(Array(slides.length).fill(true));

    const handleApproveOrReject = (index) => {
        setVisibleCards((prev) => prev.map((card, i) => (i === index ? false : card)));
    };

    return (
        <div className="min-h-screen bg-Blue flex flex-col items-center">
            <Nav />
            <h1 className="text-5xl pt-24 text-orange">Panel de Adopciones</h1>
            <div 
                className="h-auto w-[80%] bg-Blue mt-28 rounded-lg flex flex-col justify-center items-center pt-14 pb-10" 
                style={{ 
                    boxShadow: `
                        inset 0 4px 10px rgba(0, 0, 0, 0.4),
                        inset 0 8px 20px rgba(0, 0, 0, 0.3),
                        inset 0 12px 40px rgba(0, 0, 0, 0.2),
                        inset 0 16px 60px rgba(0, 0, 0, 0.15),
                        inset 0 20px 80px rgba(0, 0, 0, 0.1)
                    `
                }}

            >
                {slides.map((slide, index) => (
                    visibleCards[index] && (
                        <div
                            key={index}
                            className="w-[80%] h-24 bg-Blue rounded-lg overflow-hidden transition-all duration-700 ease-out hover:scale-105 hover:h-[70vh] hover:w-[80%] flex justify-between items-center mb-4"
                            style={{
                                boxShadow: `
                                    inset 0 4px 10px rgba(0, 0, 0, 0.4),
                                    inset 0 8px 20px rgba(0, 0, 0, 0.3),
                                    inset 0 12px 40px rgba(0, 0, 0, 0.2),
                                    inset 0 16px 60px rgba(0, 0, 0, 0.15),
                                    inset 0 20px 80px rgba(0, 0, 0, 0.1)
                                `
                            }}
                            onMouseEnter={(e) => {
                                e.currentTarget.style.boxShadow = `
                                    0 4px 10px rgba(0, 0, 0, 0.4),
                                    0 8px 20px rgba(0, 0, 0, 0.3),
                                    0 12px 40px rgba(0, 0, 0, 0.2),
                                    0 16px 60px rgba(0, 0, 0, 0.15),
                                    0 20px 80px rgba(0, 0, 0, 0.1)
                                `;
                                setHoveredIndex(index);
                            }}
                            onMouseLeave={(e) => {
                                e.currentTarget.style.boxShadow = `
                                    inset 0 4px 10px rgba(0, 0, 0, 0.4),
                                    inset 0 8px 20px rgba(0, 0, 0, 0.3),
                                    inset 0 12px 40px rgba(0, 0, 0, 0.2),
                                    inset 0 16px 60px rgba(0, 0, 0, 0.15),
                                    inset 0 20px 80px rgba(0, 0, 0, 0.1)
                                `;
                                setHoveredIndex(null);
                            }}
                        >  
                            <img 
                                src={slide} 
                                alt={`Animal ${index + 1}`} 
                                className="w-[30%] h-[85%] rounded-lg object-cover ml-11 shadow-2xl"
                            />
                            <div className="ml-4 text-white mr-40 text-[6vh] flex flex-col">
                                <p className="mr-56">{infoSlides[index]}</p>
                                {hoveredIndex === index && (
                                    <div className="flex flex-col">
                                        <div className="flex">
                                            <div>
                                                <p className="mt-2 text-[2vh] gap-10 w-80">
                                                    <strong>Especie:</strong> {InfoExtra[index].Especie} <br />
                                                    <strong>Raza:</strong> {InfoExtra[index].Raza} <br />
                                                    <strong>Edad:</strong> {InfoExtra[index].Edad} años <br />
                                                    <strong>Sexo:</strong> {InfoExtra[index].Sexo} <br />
                                                    <strong>Salud:</strong> {InfoExtra[index].Salud} <br />
                                                    <strong>Tamaño:</strong> {InfoExtra[index].Tamaño}
                                                </p>
                                            </div>
                                            <div className="mt-2 text-[2vh] gap-10 ml-16 w-96">
                                                <p><strong>Adoptante:</strong> {infoAdoptante[index].name}</p>
                                                <p><strong>Apellido:</strong> {infoAdoptante[index].lastName}</p>
                                                <p><strong>Telefono:</strong> {infoAdoptante[index].cellphoneNumber}</p>
                                                <p><strong>Estado Civil:</strong> {infoAdoptante[index].civilStatus}</p>
                                                <p><strong>Mascotas Actuales:</strong> {infoAdoptante[index].actualPets}</p>
                                                <p><strong>Miembros de la familia:</strong> {infoAdoptante[index].familyMembers}</p>
                                                <p><strong>Email:</strong> {infoAdoptante[index].email}</p>
                                                <p><strong>País:</strong> {infoAdoptante[index].country}</p>
                                                <p><strong>Razon de Adopcion:</strong> {infoAdoptante[index].adoptionReason}</p>
                                            </div>
                                        </div>
                                        <div className="flex justify-center mt-16 gap-40">
                                            <button 
                                                className="text-2xl text-red-600 hover:scale-125 transition-all"
                                                onClick={() => handleApproveOrReject(index)}
                                            >
                                                Rechazar
                                            </button>
                                            <button 
                                                className="text-2xl text-orange hover:scale-125 transition-all"
                                                onClick={() => handleApproveOrReject(index)}
                                            >
                                                Aprobar
                                            </button>
                                        </div>
                                    </div>
                                )}
                            </div>
                        </div>
                    )
                ))}
            </div>
        </div>
    );
};
