export const getPets = async () => {
    try {
        const url = "https://c21-38-n-java-react-production.up.railway.app/api/public/pets";

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