import { useEffect, useState } from "react";
import { getTokenCookie } from "../lib/cookiesSession";

export const ButtonAdd = ({ id, description }) => {
  const [token, setToken] = useState("");
  useEffect(() => {
    setToken(getTokenCookie());
  }, []);

  const handleClick = () => {
    const getListPets = async () => {
      try {
        const dataInfo = {
          petId: id,
          description: description
        };
        
        const response = await fetch('https://c21-38-n-java-react-production.up.railway.app/api/pets/adopt', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
            "Authorization": `Bearer ${token}`,
          },
          body: JSON.stringify(dataInfo), // Asegúrate de que sea una cadena JSON
        });
        
        const data = await response.json();

        console.log(data);
      } catch (error) {
        console.log(error);
      }
    };
    
    if (token) {
      getListPets();
    }
  };

  return (
    <button
      onClick={handleClick}
      className="text-2xl w-52 h-16 rounded bg-orange text-white relative overflow-hidden group z-10 hover:text-white hover:rounded-3xl transition-all duration-1000"
    >
      <span
        className="absolute bg-yellow-400 w-52 h-36 rounded-full group-hover:scale-100 scale-0 -z-10 -left-2 -top-10 group-hover:duration-500 duration-700 origin-center transform transition-all"
      ></span>
      <span
        className="absolute bg-yellow-700 w-56 h-36 -left-2 -top-10 rounded-full group-hover:scale-100 scale-0 -z-10 group-hover:duration-700 duration-500 origin-center transform transition-all"
      ></span>
      Aplicar a Adoptar
    </button>
  );
};
