export const createPet = async (datas) => {
    try {
        const url = "https://c21-38-n-java-react.onrender.com/api/pets";
        const formData = new FormData();
        
        // Cambiar los nombres de las claves
        formData.append('size', datas["Tamaño"]);
        formData.append('gender', datas["Genero"]);
        formData.append('name', datas["Nombre"]);
        formData.append('healthStatus', datas["Estado de salud"]);
        formData.append('breed', datas["Raza"]);
        formData.append('specie', datas["Especie"]);
        formData.append('descriptionBreed', datas["Descripción"]);  // Asegúrate de corregir el nombre
        formData.append('age', datas["Edad"]);
        
        formData.append('image', datas["Foto"]);
        
        console.log(...formData.entries());  // Verifica qué datos estás enviando

        // Enviar el FormData sin headers 'Content-Type'
        const response = await fetch(url, {
            method: 'POST',
            body: formData  // Enviar el FormData directamente
        });

        const result = await response.json();
        console.log(result);
        return result;
    } catch (error) {
        console.log(error);
    }
};