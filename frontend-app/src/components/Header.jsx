import {Nav} from "./Nav.jsx"
import '../index.css'

export const Header=()=>{
    return(
        <header className="flex-col justify-center items-center"> 

            <div className="flex-col justify-center items-center relative">
                <div className="w-full flex justify-center absolute z-10 ">
                    <Nav></Nav>
                </div>
                <img src="/images/HeaderIMG.jpg" className="w-full h-[550px] object-cover custom-brightness" />
                <p className="absolute w-[64%] bottom-10 right-20 text-xl text-justify lg:text-3xl md:text-2xl transition-all duration-500 lg:w-[33.8%] text-[#F8F9FA]">
                Cada año, miles de mascotas buscan un lugar al que llamar hogar, y en ese proceso, nos enseñan <br/> 
                lo que significa la conexión verdadera.<br /> Al elegir adoptar, no solo estás salvando 
                una vida, estás creando un vínculo de confianza, alegria, cuidado , y sobre todo <strong className="text-[#F39C12] text-5xl absolute transform -translate-y-3 translate-x-3">amor</strong> <br />
                </p>
            </div>
        </header>
    )
}
