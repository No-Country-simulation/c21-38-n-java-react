import {Lista} from "./Lista.jsx"
import { Nav } from "../../Nav.jsx";
import { camposMascota } from "./camposMascota.js";
import { createPet } from "../../../store/api/createMascota.js";
import { convertImageToWebP } from "../../../utils/webp.js";

export const CrearFormulario = ({title, photo}) => {

    const handleSubmit = async (event) => {
        event.preventDefault();
        
        // No usar Object.fromEntries, obtener directamente el FormData
        const formData = new FormData(event.target);  // Obtener FormData desde el formulario
        const originalImage = formData.get('Foto');
        const webpImage = await convertImageToWebP(originalImage);
        // Crear un objeto con los datos del FormData
        const fields = {
            "Tamaño": formData.get("Tamaño"),
            "Genero": formData.get("Genero"),
            "Nombre": formData.get("Nombre"),
            "Estado de salud": formData.get("Estado de salud"),
            "Raza": formData.get("Raza"),
            "Especie": formData.get("Especie"),
            "Descripción": formData.get("Descripción"),
            "Edad": formData.get("Edad"),
            "Foto": webpImage  // Aquí obtienes el archivo
        };
    
        // Enviar los datos
        const response = await createPet(fields);
        console.log(response);
    };

    return (
        <section className="h-full w-full bg-cover bg-center flex flex-col justify-center items-center" 
            style={{ backgroundImage: `url('/public/images/${photo}')` }}
        >
            <div className="w-[90%] flex justify-center mt-[0.1%] ">
                <Nav/>
            </div>

            <div className="bg-Blue/50 backdrop-blur-2xl w-[80%] lg:w-[30%] h-[90%] flex flex-col justify-center items-center mt-10 mb-8 py-10 rounded-3xl border border-orange">
                <h1 className="text-3xl text-orange font-medium mb-5">{title}</h1>

                <form onSubmit={handleSubmit} className="flex flex-col justify-center items-center">
                    <div className="flex flex-col gap-5">
                        {camposMascota.map((campo, index) => (
                            <div className="h-auto" key={index}>
                                    <Lista nombreCampo={campo.nombreCampo} tipo={campo.tipo} isImput={campo.isImput} />
                            </div>
                        ))}
                    </div>
                    <button className="text-2xl text-Newhite mt-10 border rounded-3xl p-2 w-full hover:bg-Blue hover:scale-105 transition-all">
                        {title}
                    </button>
                </form>

            </div>
        </section>
    )
}
