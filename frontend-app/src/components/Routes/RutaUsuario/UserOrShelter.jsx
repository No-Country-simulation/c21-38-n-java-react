import { Formulario } from "./CrearFormularioUsuario"
import { Nav } from "../../Nav"
import { preguntasAdoptante,preguntasVeterinaria } from "./PreguntasUsuario";
import { useState } from "react";

export const UserOrShelter = ({photo, titulo}) =>{
    const [isFormActive, setIsFormActive] = useState(false);
    const [isAdoptante, setIsAdoptante] = useState(true);

    const toggleActiveForm = () => setIsFormActive(true);
    const toggleIsAdoptante = () => setIsAdoptante(true);
    const toggleRefugio = () => setIsAdoptante(false);


    return(
        <main className={`p-10  bg-cover ${isFormActive ? "h-full" : "h-screen"} bg-center flex flex-col justify-center items-center`} 
            style={{ backgroundImage: `url('/public/images/${photo}')` }}>
            
            <Nav/>

            <div className="flex w-[50%] gap-20">
                    <button type="submit" className="w-full  mt-9 text-xl border bg-Blue text-white p-2 rounded-md hover:bg-orange hover:text-Blue hover:scale-[101%]" onClick={() => { toggleIsAdoptante();toggleActiveForm(); }}>
                        Soy un Adoptante
                    </button>
                    <button type="submit" className="w-full  mt-9 text-xl border bg-Blue text-white p-2 rounded-md hover:bg-orange hover:text-Blue hover:scale-[101%] " onClick={() => { toggleRefugio();toggleActiveForm(); }}>
                        Soy un Refugio
                    </button>

            </div>

            {isFormActive && (<Formulario titulo={titulo} preguntas={isAdoptante? preguntasAdoptante : preguntasVeterinaria} URL={isAdoptante ? "https://c21-38-n-java-react-production.up.railway.app/api/auth/adopter" : "https://c21-38-n-java-react-production.up.railway.app/api/auth/shelter"} />)}

        </main>
    )
}