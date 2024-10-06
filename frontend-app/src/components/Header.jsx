import {Nav} from "./Nav.jsx"
import '../index.css'

export const Header=()=>{
    return(
            <header> 
            <Nav></Nav>
            <div className="flex justify-center items-center relative">
                <img src="/images/HeaderIMG.jpg" className="w-full h-96 object-cover custom-brightness" />
                <p className="absolute w-[64%] bottom-10 right-20 text-xl text-justify lg:text-3xl md:text-2xl transition-all duration-500 lg:w-[34.1%] ">
                    Somos una familia dedicada a crear 
                    conexiones únicas entre personas y mascotas.<br/> Queremos brindarle una nueva oportunidad 
                    a vidas que están en búsqueda de un hogar.<br/> Creemos que cada una
                    merece un lugar donde ser feliz, una adopción a la vez.
                </p>
            </div>
        </header>
    )
}
