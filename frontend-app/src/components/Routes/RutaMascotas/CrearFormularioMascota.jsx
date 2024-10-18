import { Lista } from "./Lista.jsx";
import { Nav } from "../../Nav.jsx";
import { camposMascota } from "./camposMascota.js";
import { useEffect, useState } from "react";
import { Check } from "../../CheckPetAdd.jsx";

export const CrearFormulario = ({ title, photo }) => {
    const [seeNotice, setSeeNotice] = useState("hidden");


    const handleSeeNotice = () => {
        setSeeNotice("flex");
    };


    useEffect(() => {
        if (seeNotice === "flex") {
            const timer = setTimeout(() => {
                setSeeNotice("hidden"); 
            }, 6000); 

            return () => clearTimeout(timer);
        }
    }, [seeNotice]);

    return (


            <div className="bg-Blue/50 backdrop-blur-2xl flex flex-col justify-center items-center mb-5 rounded-3xl ">
                <h1 className="text-3xl text-orange font-medium">{title}</h1>

                <div className="flex flex-col justify-center items-center">
                    <div>
                        {camposMascota.map((campo, index) => (
                            <div className="flex" key={index}>
                                <Lista nombreCampo={campo.nombreCampo} tipo={campo.tipo} isImput={campo.isImput} />
                            </div>
                        ))}
                    </div>

                    <button
                        className="text-2xl text-Newhite mt-10 border rounded-3xl p-2 w-full hover:bg-Blue hover:scale-105 transition-all"
                        onClick={handleSeeNotice}
                    >
                        {title}
                    </button>
                </div>
            <div className={`absolute flex justify-center w-full ${seeNotice}`}>
                <Check />
            </div>
            </div>


    );
};
