import React, { useEffect, useRef } from 'react';
import '../index.css';
import { Huellita } from './Huellita';

interface Props {
    pet: {
        name: string;
        years: string;
        raza: string;
        address: string;
        image: string;
    },
    reverse: boolean
}

export const Mascota = ({ pet, reverse }: Props) => {
    const { name, years, raza, address, image } = pet;





    return (
        <section

            className={`mascota relative w-[100%] md:w-[80%] h-auto justify-center items-center flex gap-40 pt-20 pb-20 mb-1 p-10 border-t-2 rounded-lg border-[#1F485C] color-azul ${reverse ? "flex-col lg:flex-row" : "flex-col lg:flex-row-reverse"}`}>
            <img src={`images/${image}`} className="w-60 h-60 object-cover rounded-full border-4 border-[#F39C12] transition-all duration-200 p-5 hover:p-0" alt={`Section de nuestro amigo ${name}`} />
            <div className="flex flex-col justify-center items-center gap-2 z-20">
                <p className="text-5xl mb-5">¡¡Hola!!, soy <span className="font-bold text-orange">{name}</span></p>
                <p className="text-3xl">Edad: {years}</p>
                <p className="text-3xl">Raza: {raza}</p>
                <p className="text-3xl text-center">Dirección: {address}</p>
            </div>
            <Huellita 
                width={Math.floor(Math.random() * (15 - 8 + 1) + 8)}
                marR={Math.floor(Math.random() * (10 - 0 + 1) + 0)}
                marT={Math.floor(Math.random() * (40 - 0 + 1) + 0)}
                rot={Math.floor(Math.random() * (360 + 1))}
            />
            <Huellita 
                width={Math.floor(Math.random() * (12 - 7 + 1) + 7)}
                marR={Math.floor(Math.random() * (85 - 70 + 1) + 70)}
                marT={Math.floor(Math.random() * (20 - -20 + 1) + -20)}
                rot={Math.floor(Math.random() * (360 + 1))}
            />
        </section>
    );
};