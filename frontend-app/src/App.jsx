import { useEffect, useState } from "react"
import { Header } from "./components/Header"
import { Mascotas } from "./components/Mascotas"
import { SobreNosotros } from "./components/SobreNosotros"
import { Footer } from "./components/Footer"


import { BotonFlotante } from "./components/BotonFlotante"




function App() {

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

  const [pets, setPets] = useState([])

  useEffect(() => {
    try {
      const listPets = mascotas
      console.log(listPets)
      setPets(mascotas)
    } catch (error) {
      console.log(error)
    }
  }, [])

  return (
    <>
      <Header/>

      <main className="w-full h-auto flex-col  justify-center bg-[#F8F9FA] ">

        <SobreNosotros/>

        <Mascotas pets={pets} />
        
      </main>
      <footer>
        <Footer/>
      </footer>

      <div className="">
        <BotonFlotante/>
      </div>
    </>
  )
}

export default App