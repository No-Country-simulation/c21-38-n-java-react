import { useEffect, useState } from "react"
import 'ldrs/tailChase'
// import { mascotas } from "../../store/mascotas"

export const Pets = () => {

    const [listPets, setListPets] = useState([])
  // const [listPets, setListPets] = useState(mascotas)

    useEffect(() => {

        const getListPets = async () => {
            try {
                const response = await fetch('https://c21-38-n-java-react.onrender.com/api/pets')
                const data = await response.json()
                console.log(data)
                setListPets(Array.isArray(data.body) ? data.body : []);
            } catch (error) {
                setListPets([])
                console.log(error)
            }
    }
    getListPets()

    }, [])

    return (
        <div className="w-full flex flex-col justify-center items-center pb-24">
            <h1 className="text-4xl my-12 text-blue font-bold">Amigos que buscan hogar</h1>
            {
                listPets.length === 0
                ?
                <div className="m-5">
                    <l-tail-chase
                        size="100"
                        speed="1.75"
                        color="black"
                    ></l-tail-chase>
                </div>
                :
                <div className=" flex flex-wrap justify-center items-center">
                    {
                        listPets.map(pet => (
                        <div key={pet.name} className="group cursor-pointer relative hover:scale-105 hover:z-30 transition-all duration-200">
                            <div className="flex flex-col border-gray-400 h-[400px] w-[400px] bg-gray-100 group-hover:brightness-100">
                                    <img 
                                        src={pet.imageProfile || "/images/cachorro3.jpg"} 
                                        alt={pet.name} 
                                        className="w-full h-full object-cover brightness-50 group-hover:brightness-80"
                                        onError={(e) => e.target.src = "/images/perro8.jpg"}
                                    />
                                <div className="absolute w-[30%] bottom-4 left-4 font-semibold text-2xl text-gray-200 group-hover:text-white">
                                    <p>{pet.name}</p>
                                    <p>{pet.breed}</p>
                                </div>
                            </div>
                        </div>
                    ))
                    }
                </div>
            }
        </div>
    )
}