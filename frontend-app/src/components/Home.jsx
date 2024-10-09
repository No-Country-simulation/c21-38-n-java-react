import App from "../App"
import { Mascotas } from "./Mascotas"
import { SobreNosotros } from "./SobreNosotros"

export const Home=()=>{

    const mascotas = [
        {
            "name": "Milo",
            "years": "3 años",
            "raza": "Border Collie",
            "address": "Bogota - Colombia",
            "image": "perro1.jpg"
        },
        {
            "name": "Bluss",
            "years": "5 años",
            "raza": "Pastor Collie",
            "address": "Buenos Aires - Argentina",
            "image": "gato2.jpg"
        },
        {
            "name": "Lulu",
            "years": "2 años",
            "raza": "Pincher",
            "address": "Ciudad de Mexico - Mexico",
            "image": "cachorrog1.jpg"
        },
        {
            "name": "Yogui",
            "years": "6 años",
            "raza": "PittBull",
            "address": "Medellin - Colombia",
            "image": "cachorrop2.jpg"
        }
    ]

    return(
        <App>
            <SobreNosotros/>

            <Mascotas pets={mascotas} />
        </App>
    )
}