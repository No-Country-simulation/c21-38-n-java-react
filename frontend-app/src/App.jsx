import { useEffect, useState } from "react"
import { Header } from "./components/Header"
import { Mascotas } from "./components/Mascotas"
import { Huellita } from "./components/Huellita"
import { SobreNosotros } from "./components/SobreNosotros"
// import { mascotas } from "./store/mascotas"



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

        
          <Huellita 
            width={4}
            marR={126}
            marL={0}
            marT={20}
            rot={45}
          />

          <Huellita 
            width={6}
            marR={10}
            marL={120}
            marT={60}
            rot={-63}
          />

          <Huellita 
            width={8}
            marR={126}
            marL={0}
            marT={90}
            rot={-10}
          />

          <Huellita 
            width={4}
            marR={10}
            marL={120}
            marT={120}
            rot={25}
          />

          <Huellita 
            width={7}
            marR={250}
            marL={120}
            marT={180}
            rot={56}
          />
        
      </main>
      <footer>

      </footer>
    </>
  )
}

export default App