import React from 'react';
import '../index.css'


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

export const Mascota = ({pet, reverse}: Props) => {

    const { name, years, raza, address, image} = pet

    return (
        <section
            className={`w-[65%] h-auto justify-center items-center flex gap-40  pt-20 pb-20 mb-1 p-10  border-t-2  rounded-lg border-[#1F485C] color-azul ${reverse == true ? "flex-col lg:flex-row" : "flex-col lg:flex-row-reverse"}`}>
            <img src={`images/${image}`} className="w-60 h-60 object-cover rounded-full border-4  border-[#F39C12]  p-5 " alt={`Section de nuestro amigo ${name}`} />
            <div className="flex flex-col justify-center items-center gap-2 ">
                <p className="text-3xl">¡¡Hola!!, soy <span className="font-bold">{name}</span></p>
                <p className="text-xl">Edad: {years}</p>
                <p className="text-xl">Raza: {raza}</p>
                <p className="text-xl text-center">Dirreccion: {address}</p>
            </div>
            
        </section>
    )
}

