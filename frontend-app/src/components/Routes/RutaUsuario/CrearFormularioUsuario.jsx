import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useLogin } from "../../../store/login/login";
import { setTokenCookie } from "../../../lib/cookiesSession";


export const Formulario = ({ titulo, preguntas, URL }) => {
  const navigate = useNavigate()
  const { initSession } = useLogin()
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

  const handleChange = (e, type) => {
    const { name, value } = e.target;
    let setValue = value
    if (type === "number") {
      setValue = parseInt(value)
    }
    setUserInfo((prevInfo) => ({
      ...prevInfo,
      [name]: setValue,
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
      console.log(response)
      if (response.status === 200) {
        const data = await response.json();
        if (data.message === "El refugio fue registrado exitosamente") {
          initSession(data.body.adopter, data.body.token, "SHELTER")
          setTokenCookie(data.body.token)
        } else {
          initSession(data.body.adopter, data.body.token, "ADOPTER")
          setTokenCookie(data.body.token)
        }
        console.log("Adoptante registrado exitosamente:", data);
        navigate('/login')
        // Aquí puedes manejar la respuesta del servidor
      } else {
        console.error("Error al registrar adoptante:", response.status);
      }
    } catch (error) {
      console.error("Error en la solicitud:", error);
    }
  };

  return (
    <form onSubmit={handleSubmit} className="bg-Blue/50 backdrop-blur-2xl h-full w-[70%] rounded-2xl px-28 text-Newhite flex flex-col justify-center mt-14 border-2 border-orange py-10">
      <h1 className="text-3xl mb-9 font-medium flex justify-center">{titulo}</h1>

      <div className="grid grid-cols-3 gap-6 justify-center items-center">
        {preguntas.map((pregunta, index) => {
          if (pregunta.tipo !== "select") {
            return (

              <div key={index} className="mb-6 text-lg">
                <label className="block text-lg font-medium">{pregunta.texto}</label>
                <input
                  required
                  type={pregunta.tipo}
                  name={pregunta.name}
                  value={userInfo[pregunta.name] || ""}
                  onChange={(e) => handleChange(e, pregunta.tipo)}
                  className="mt-1 block w-full p-2 border border-gray-300 text-Blue rounded-md"
                />
              </div>
            )
          } else {
            return (
              <div key={index} className="mb-6 text-lg text-Blue">
                <h1 className="text-Newhite block text-lg font-medium">{pregunta.texto}</h1>
                <select
                  onChange={(e) => handleChange(e, pregunta.tipo)}
                  name={pregunta.name}
                  required
                  className="w-[35vh] h-12 mt-1 rounded-md"
                  >
                  <option value="">-- Seleccione --</option>
                  {
                    pregunta.options.map(pregunta => (
                      <option value={pregunta.value} key={pregunta}>{pregunta.name}</option>
                    ))
                  }
                  <option value=""></option>
                </select>
              </div>
            )
          }
        })}
      </div>

      <button
        type="submit"
        className="w-full mt-9 text-xl border bg-Blue text-white p-2 rounded-md hover:bg-orange hover:text-Blue hover:scale-[101%]"
      >
        {titulo}
      </button>
    </form>
  );
};