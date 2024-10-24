import { Link } from "react-router-dom";
import { useState } from "react";

export const Formulario = ({ titulo, preguntas }) => {
    // Estado para almacenar los datos del nuevo usuario
    const [formData, setFormData] = useState({});

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData((prevData) => ({
            ...prevData,
            [name]: value,
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault(); // Evita el comportamiento por defecto del formulario

        try {
            const response = await fetch("https://c21-38-n-java-react-production.up.railway.app/api/auth/adopter", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(formData), // Envía los datos del formulario
            });

            if (!response.ok) {
                throw new Error("Error al crear el usuario");
            }

            const data = await response.json();
            console.log("Usuario creado:", data);
            // Aquí puedes redirigir o mostrar un mensaje de éxito

        } catch (error) {
            console.error("Error al crear el usuario:", error);
            // Manejo de errores
        }
    };

    return (
        <form onSubmit={handleSubmit} className="bg-Blue/50 backdrop-blur-2xl h-full w-[50%] rounded-2xl px-52 text-Newhite flex flex-col justify-center mt-14 border-2 border-orange py-10">
            <h1 className="text-3xl mb-9 font-medium flex justify-center">{titulo}</h1>

            {preguntas.map((pregunta, index) => (
                <div key={index} className="mb-6 text-lg">
                    <label className="block text-lg font-medium">{pregunta.texto}</label>
                    <input 
                        type={pregunta.tipo} 
                        name={pregunta.texto.toLowerCase().replace(/\s+/g, '')} // Crea un nombre para el input
                        onChange={handleChange} // Agrega el manejador de cambios
                        className="mt-1 block w-full p-2 border border-gray-300 text-Blue rounded-md" 
                    />
                </div>
            ))} 

            <button 
                type="submit" 
                className="w-full mt-9 text-xl border bg-Blue text-white p-2 rounded-md hover:bg-orange hover:text-Blue hover:scale-[101%]"
            >
                {titulo}
            </button>
        </form>
    );
};
