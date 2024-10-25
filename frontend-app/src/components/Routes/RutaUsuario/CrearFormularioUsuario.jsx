import { useState } from "react";


export const Formulario = ({ titulo, preguntas,URL }) => {
    const [userInfo, setUserInfo] = useState({
        name: "",
        lastName: "",
        email: "",
        country: "",
        cellphoneNumber: "",
        birthDate: "",
        civilStatus: "",
        actualPets: 0,
        familyMembers: 0,
        adoptionReason: "",
        dailyTimeAvailable: 0,
        houseType: "",
        houseExtension: 0,
        identificationType: "",
        identificationNumber: "",
        password: "",
        city: "",
        imageProfile: null // Imagen por defecto como null
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setUserInfo((prevInfo) => ({
            ...prevInfo,
            [name]: value,
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await fetch(URL, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(userInfo),
            });

            if (response.ok) {
                const data = await response.json();
                console.log("Adoptante registrado exitosamente:", data);
                // Aquí puedes manejar la respuesta del servidor
            } else {
                console.error("Error al registrar adoptante:", response.status);
            }
        } catch (error) {
            console.error("Error en la solicitud:", error);
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
                        name={pregunta.name}
                        value={userInfo[pregunta.name] || ""}
                        onChange={handleChange}
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