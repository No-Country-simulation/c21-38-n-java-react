import { useState } from "react"
import { Formulario } from "../Formulario"
import { Nav } from "../Nav"


export const Registre = () =>{
    const [isFormActive, setIsFormActive] = useState(false)
    const [isAdoptante, setIsAdoptante] = useState(true)


    const preguntasAdoptante = [
        { texto: 'Nombre de usario', tipo:'text' },
        { texto: 'Correo Electrónico', tipo:'email' },
        { texto: 'Contraseña', tipo:'password'},
        {texto: 'Repetir Contraseña', tipo:'password'},
        {texto: 'Direccion',tipo:'text'},
        {texto: 'Telefono', tipo:'number'}
    ];
    
    const preguntasVeterinaria = [
        { texto: 'Nombre del establecimiento' },
        { texto: 'Quit del establecimiento' },
        {texto: 'Contraseña'},
        {texto:'Repetir Contraseña'},
        {texto: 'Direccion del establecimiento'},
        {texto: 'Telefono del establecimiento'}
    ];

    const toggleActiveForm = () => setIsFormActive(true)

    const toggleIsAdoptante = () => setIsAdoptante(true)
    const toggleRefugio = () => setIsAdoptante(false)

    return(
        <main className={`p-10  bg-cover ${isFormActive ? "h-full" : "h-screen"} bg-center flex flex-col justify-center items-center`} style={{ backgroundImage: `url('/public/images/3perros.jpg')` }}>
            
            <Nav/>

            <div className="flex w-[50%] gap-20">
                    <button type="submit" className="w-full  mt-9 text-xl border bg-Blue text-white p-2 rounded-md hover:bg-orange hover:text-Blue hover:scale-[101%]" onClick={() => { toggleIsAdoptante();toggleActiveForm(); }}>
                        Soy un Adoptante
                    </button>
                    <button type="submit" className="w-full  mt-9 text-xl border bg-Blue text-white p-2 rounded-md hover:bg-orange hover:text-Blue hover:scale-[101%] " onClick={() => { toggleRefugio();toggleActiveForm(); }}>
                        Soy un Refugio
                    </button>

            </div>

            {isFormActive && (<Formulario preguntas={isAdoptante? preguntasAdoptante : preguntasVeterinaria} />)}

        </main>
    )
}