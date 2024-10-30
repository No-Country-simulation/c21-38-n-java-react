import { useState } from "react";
import { Carousel } from "./Carousel";
import { Nav } from "../Nav"


const slides = [
    // Acá irían las imágenes que saquemos del back
    "./../../../public/images/cachorrog1.jpg",
    "./../../../public/images/cachorrog2.jpg",
    "./../../../public/images/cachorrog3.jpg",
    "./../../../public/images/cachorrog5.jpg",
];

const infoSlides = [
    // Acá iría la descripción
    "Información sobre cachorrog1",
    "Información sobre cachorrog2",
    "Información sobre cachorrog3",
    "Información sobre cachorrog5",
];

export const MisAdopciones = () => {
    const [currentSlide, setCurrentSlide] = useState(0);
    const handleSlideChange = (newIndex) => {
        setCurrentSlide(newIndex);
    };

    return (
        <div className="bg-Blue  flex flex-col items-center justify-center gap-11">
            <Nav/>
            <h1 className="text-4xl text-Newhite mt-12 mb-12">Las adopciones a las que aplicó</h1>
            <div className="flex justify-center items-center">

                <div className="max-w-xl p-10">
                    <Carousel 
                        autoSlide={true} 
                        autoSlideInterval={10000} 
                        onSlideChange={handleSlideChange} 
                    >
                        {slides.map((s, index) => (
                            <img
                                key={index}
                                src={s}
                                alt={`Slide ${index + 1}`}
                                className="object-cover rounded-full"
                            />
                        ))}
                    </Carousel>
                </div>
                
                <div className="h-96 w-[70vh] rounded-3xl flex justify-center items-center">
                    <div className="h-[90%] w-[94%] rounded-2xl flex flex-col justify-between items-center p-4">
                        <p className="text-center text-lg text-Newhite">
                            {infoSlides[currentSlide]}
                        </p>
                        <p>Estado</p>
                    </div>
                </div>
            </div>

        </div>
    );
};
