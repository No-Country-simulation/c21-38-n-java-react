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
                nombre: "Nombre de Usuario",
                email: "Usuario@gmail.com",
                direccion: "Direccion 7756",
                telefono: "2236979758",
                /* 
                    agregar campos: 

                        "birthDate": "2024-10-24",
                        "civilStatus": "SINGLE",
                        "actualPets": 0,
                        "familyMembers": 0,
                        "adoptionReason": "string",
                        "dailyTimeAvailable": 0,
                        "houseType": "APARTMENT",
                        "houseExtension": 0,
                        "name": "string",
                        "lastname": "string",
                        "identificationType": "CC",
                        "identificationNumber": 0,
                        "email": "string",
                        "password": "string",
                        "cellphoneNumber": "string",
                        "imageProfile": "string",
                        "country": "string",
                        "city": "string"

                    */
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

    return (
        <section className="bg-Blue min-h-screen flex flex-col items-center h-full">
            <div className="w-[93%] h-[500px] bg-orange rounded-3xl">
                <div className="mt-4">
                    <Nav width="full" shadow="0" />
                    <div className="w-96 h-96 bg-orange absolute ml-[72%] mt-24 rounded-full flex flex-col items-center">
                        <div className="w-56 mt-20">
                            <img src="./../../../../public/images/usuario.svg" alt="" />
                        </div>
                    </div>
                </div>

                <div className="w-full h-[80%] flex flex-col items-center mt-7">
                    <div className="flex">
                      {/* Nombre del usuario */}
                        {isEditing ? (
                            <input
                                type="text"
                                name="nombre"
                                value={userInfo.nombre}
                                onChange={handleChange}
                                className="mt-10 text-6xl border-b-2 border-gray-400 focus:outline-none bg-Blue text-Newhite rounded-xl pl-8 w-[45vh]"
                            />
                        ) : (
                        <h1 className="mt-10 text-6xl">{userInfo.nombre}</h1>
                        )}

                        <button
                            onClick={handleEditClick}
                            className={`absolute  flex flex-col items-center hover:scale-105 text-Blue 
                                ${isEditing ? "mt-12" : " mt-10"} 
                                ${isEditing ? "ml-[70vh]" : " ml-[70vh]"}`}
                        >
                            <MdModeEditOutline className="text-4xl" />
                            <p className="text-xl">{isEditing ? "Guardar" : "Editar"}</p>
                        </button>
                    </div>
                    
                    <div className="mt-14 flex">
                        <div className="flex flex-col items-end text-4xl gap-7 mr-40">
                            <p>Correo Electrónico :</p>
                            <p>Dirección :</p>
                            <p>Teléfono :</p>
                        </div>
                    
                        <div className="flex flex-col items-start text-4xl gap-7">
                          {/* Email */}
                            {isEditing ? (
                                <input
                                    type="email"
                                    name="email"
                                    value={userInfo.email}
                                    onChange={handleChange}
                                    className="border-b-2 border-gray-400 focus:outline-none bg-Blue text-Newhite rounded-xl pl-3"
                                />
                            ) : (
                                <p>{userInfo.email}</p>
                            )}

                          {/* Dirección */}
                            {isEditing ? (
                                <input
                                    type="text"
                                    name="direccion"
                                    value={userInfo.direccion}
                                    onChange={handleChange}
                                    className="border-b-2 border-gray-400 focus:outline-none bg-Blue text-Newhite rounded-xl pl-3"
                                />
                            ) : (
                                <p>{userInfo.direccion}</p>
                            )}

                          {/* Teléfono */}
                            {isEditing ? (
                                <input
                                    type="tel"
                                    name="telefono"
                                    value={userInfo.telefono}
                                    onChange={handleChange}
                                    className="border-b-2 border-gray-400 focus:outline-none bg-Blue text-Newhite rounded-xl pl-3"
                                />
                            ) : (
                                <p>{userInfo.telefono}</p>
                            )}
                        </div>
                    </div>
                </div>
            </div>

          {/* Resto del contenido */}
            <div className="absolute w-[45vh] mr-[140vh] mt-[15vh]">
                <img src="./../../../../public/images/Forma4.svg" alt="" />
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
