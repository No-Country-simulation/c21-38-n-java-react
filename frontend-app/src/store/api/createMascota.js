import { getTokenCookie } from "../../lib/cookiesSession";

export const createPet = async (datas) => {
    try {
        const url = "https://c21-38-n-java-react-production.up.railway.app/api/pets";

        const formData = new FormData();
        
        const imageFile = datas["Foto"];

        formData.append('size', datas["Tamaño"]);
        formData.append('gender', datas["Genero"]);
        formData.append('name', datas["Nombre"]);
        formData.append('healthStatus', datas["Estado de salud"]);
        formData.append('breed', datas["Raza"]);
        formData.append('specie', datas["Especie"]);
        formData.append('descriptionBreed', datas["Descripción"]);
        formData.append('age', datas["Edad"]);
        formData.append('image', imageFile);

        const response = await fetch(url, {
            method: 'POST',
            body: formData,
            headers: {
                'Authorization': `Bearer ${getTokenCookie()}`, 
            },
              mode: 'cors'

        });

        if (!response.ok) {
            const errorMessage = await response.text();
            console.error(`Error ${response.status}: ${errorMessage}`);
            return null; // O maneja el error como prefieras
        }

        const result = await response.json();
        console.log(result);
        return result;
    } catch (error) {
        console.error(error);
    }
};
