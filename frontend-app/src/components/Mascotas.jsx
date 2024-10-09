import { Mascota } from "./Mascota"
import '../index.css'


export const Mascotas = ({ pets }) => {
  return (
    <div className="flex flex-col pt-[70px]  justify-center items-center w-full ">
      <h1 className="text-4xl color-azul  font-bold px-20 mb-[73px] text-center">Encuentra tu mascota, tenemos amigos que buscan cambiar su vida y la tuya</h1>
      {
        pets.map((pet , index) => (
          
            <Mascota key={pet.name} pet={pet} reverse={index % 2 == 0 ? true : false}/>

        ))
      }
    </div>
  )
}

