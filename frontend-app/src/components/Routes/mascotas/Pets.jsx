import { useEffect, useState } from "react"
import 'ldrs/tailChase'
import { Pet } from "./components/Pet"

export const Pets = () => {

  const [listPets, setListPets] = useState([])

  useEffect(() => {

    const getListPets = async () => {
      try {
        const response = await fetch('https://c21-38-n-java-react-production.up.railway.app/api/public/pets')
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
              <Pet key={pet.name} {...pet}/>
            ))
          }
        </div>
      }
    </div>
  )
}