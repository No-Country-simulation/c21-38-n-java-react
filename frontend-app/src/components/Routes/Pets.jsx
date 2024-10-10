import { useEffect, useState } from "react"
import { mascotas } from "../../store/mascotas"

export const Pets = () => {

    const [listPets, setListPets] = useState(mascotas)

    /*useEffect(() => {

        const getListPets = async () => {
            try {
                const response = await fetch('https://c21-38-n-java-react.onrender.com/api/pets')
                    .then(res => console.log(res))
                setListPets(response.body)
            } catch (error) {
                console.log(error)
            }
        }
        getListPets()

    }, [])*/

    return(
        <div className="w-full flex flex-col justify-center items-center py-40">
            <h1>Listado de mascotas</h1>
            {
                listPets.length <= 0
                ?
                <p>No se encontro ningun amigo para adoptar</p>
                :
                <div className=" flex flex-wrap gap-10 justify-center items-center">
                    {
                        listPets.map(pet => (
                            <a href={`/huellita/${pet.id}`} key={pet.name} className="cursor-pointer">
                                <div
                                className="flex flex-col border-2 border-gray-400 h-[500px] w-[400px] bg-gray-100 rounded-xl">
                                <img src={pet.imageProfile} alt="" className="w-full h-[60%] object-cover rounded-lg" />
                                <div>
                                    <p>{pet.name}</p>
                                    <p>{pet.specie}</p>
                                    <p>{pet.breed}</p>
                                    <p>{pet.descriptionBreed}</p>
                                    <p>{pet.age}</p>
                                    <p>{pet.gender}</p>
                                    <p>{pet.healthStatus}</p>
                                    <p>{pet.size}</p>
                                </div>
                            </div>
                            </a>
                        ))
                    }
                </div>
            }
        </div>
    )
}