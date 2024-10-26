import { useState, useEffect } from "react";
import { Nav } from "../../Nav";
import { MdModeEditOutline } from "react-icons/md";

export const MiPerfil = () => {
    const [isEditing, setIsEditing] = useState(false);

    const [userInfo, setUserInfo] = useState(() => {
        const savedUserInfo = localStorage.getItem("userInfo");
        return savedUserInfo
            ? JSON.parse(savedUserInfo)
            : {
                    name: "Nombre de Usuario",
                    lastName: "Espiñoza",
                    email: "Usuario@gmail.com",
                    country: "Direccion 7756",
                    cellphoneNumber: "2236979758",
                    birthDate: "2024-10-24",
                    civilStatus: "SINGLE",
                    actualPets: 0,
                    familyMembers: 0,
                    adoptionReason: "amo los animales",
                    dailyTimeAvailable: 4,
                    houseType: "APARTAMENT",
                    houseExtension: 20,
                    identificationType: "DNI",
                    identificationNumber: 4056987,
                    password: "holamundo",
                    imageProfile: null,
                    city: "mar del plata",
            };
    });

    const handleEditClick = async () => {
        if (isEditing) {
            localStorage.setItem("userInfo", JSON.stringify(userInfo));

            try {
                const response = await fetch("https://c21-38-n-java-react-production.up.railway.app/api/auth/adopter", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify(userInfo),
                });

                if (!response.ok) {
                    throw new Error("Error al enviar los datos al servidor");
                }

                const data = await response.json();
                console.log("Respuesta del servidor:", data);
            } catch (error) {
                console.error("Error al enviar los datos:", error);
            }
        }
        setIsEditing(!isEditing);
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        setUserInfo((prevState) => ({
            ...prevState,
            [name]: value,
        }));
    };

    useEffect(() => {
        const savedUserInfo = localStorage.getItem("userInfo");
        if (savedUserInfo) {
            setUserInfo(JSON.parse(savedUserInfo));
        }
    }, []);

    // Definir un array de campos a mostrar y editar
    const fields = [
        { label: "Nombre", name: "name", type: "text" },
        { label: "Apellido", name: "lastName", type: "text" },
        { label: "Correo Electrónico", name: "email", type: "email" },
        { label: "Dirección", name: "country", type: "text" },
        { label: "Teléfono", name: "cellphoneNumber", type: "tel" },
        { label: "Fecha de Nacimiento", name: "birthDate", type: "date" },
        { label: "Estado Civil", name: "civilStatus", type: "text" },
        { label: "Mascotas Actuales", name: "actualPets", type: "number" },
        { label: "Miembros de la Familia", name: "familyMembers", type: "number" },
        { label: "Razón para Adoptar", name: "adoptionReason", type: "text" },
        { label: "Tiempo Diario Disponible", name: "dailyTimeAvailable", type: "number" },
        { label: "Tipo de Vivienda", name: "houseType", type: "text" },
        { label: "Extensión de la Vivienda", name: "houseExtension", type: "number" },
        { label: "Tipo de Identificación", name: "identificationType", type: "text" },
        { label: "Número de Identificación", name: "identificationNumber", type: "text" },
        { label: "Ciudad", name: "city", type: "text" },
    ];

    return (
        <section className="bg-Blue min-h-screen flex flex-col items-center h-full">
            <div className={`w-[93%] bg-orange rounded-3xl ${isEditing ? "h-[118.5vh]": "h-[95vh]"} transition-all`} >
                <div className="mt-4">
                    <Nav width="full" shadow="0" />
                    <div className="w-96 h-96 bg-orange absolute ml-[72%] mt-24 rounded-full flex flex-col items-center">
                        <div className="w-56 mt-20">
                            <img src="./../../../../public/images/froma4.svg" alt="" />
                        </div>
                    </div>
                </div>

                <div className="w-full h-[80%] flex flex-col items-center mt-7">

                    {/* Renderizado dinámico de campos */}
                    <div className=" grid grid-cols-2 w-[80%] mr-80 gap-11 mt-24 border-4 border-Blue rounded-xl p-10 text-3xl ">

                    <div className={`flex absolute ml-[33%] ${isEditing? "mt-[1%]" : "mt-[26%]"} transition-all `}>
                        <button
                            onClick={handleEditClick}
                            className={`absolute flex flex-col items-center hover:scale-105 text-Blue 
                            ${isEditing ? "mt-12" : "mt-10"} ml-[70vh]`}
                        >
                            <MdModeEditOutline className="text-4xl" />
                            <p className="text-xl">{isEditing ? "Guardar" : "Editar"}</p>
                        </button>
                    </div>

                        {fields.map((field) => (
                            <div key={field.name} className="flex items-center">
                                <p className=" mr-10">{field.label}:</p>
                                {isEditing ? (
                                    <input
                                        type={field.type}
                                        name={field.name}
                                        value={userInfo[field.name] || ""}
                                        onChange={handleChange}
                                        className="border-b-2 border-gray-400 focus:outline-none bg-Blue text-Newhite rounded-xl pl-3 "
                                    />
                                ) : (
                                    <p>{userInfo[field.name]}</p>
                                )}
                            </div>
                        ))}
                    </div>
                </div>
            </div>

            <div className="mt-20 flex flex-col items-center w-full mb-28">
                <h2 className="text-5xl text-Newhite mb-32">Adopte siguiendo estos pasos</h2>
                <div className="flex gap-52">
                    <div className="w-full">
                        <img src="/public/images/explicacion1.svg" alt="" className="w-[100vh] ml-24" />
                    </div>
                    <div className="w-full flex">
                        <img src="/public/images/explicacion2.svg" alt="" className="ml-32" />
                    </div>
                    <div className="w-full">
                        <img src="/public/images/explicacion 3.svg" alt="" className="ml-32" />
                    </div>
                </div>
            </div>

            <div
                className="flex items-center justify-center h-[50vh] w-[93%] rounded-lg bg-cover bg-center bg-fixed"
                style={{ backgroundImage: "url(/public/images/cachorrop6.jpg)" }}
            ></div>

            <div className="flex flex-col items-center text-Newhite mt-20 mb-20">
                <h2 className="text-4xl mb-20">
                    ¿Por qué adoptar es tan importante y por qué debería hacerlo?
                </h2>
                <p className="w-[93%] text-3xl leading-relaxed tracking-wider text-justify">
                    Adoptar una mascota es una forma hermosa de darle una segunda oportunidad a un animal que ha sido abandonado. Al hacerlo, no solo estás salvando una vida, sino también ganando un compañero fiel que te llenará de amor y alegría. Adoptar ayuda a reducir la cantidad de animales en los refugios y contribuye a combatir la cría irresponsable. Además, es una decisión ética que transforma tanto tu vida como la del animal, fomentando el respeto y el cuidado por los seres vivos. Cada adopción es un acto de amor que marca una gran diferencia.
                </p>
            </div>
        </section>
    );
};
