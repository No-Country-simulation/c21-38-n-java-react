export const getPets = async () => {
    try {
        const url = "http://c21-38-n-java-react-production.up.railway.app/api/pets";

        // Enviar el FormData sin headers 'Content-Type'
        const response = await fetch(url, {
            method: 'GET',
        });

        const result = await response.json();
        console.log(result);
        return result;
    } catch (error) {
        console.log(error);
    }
};