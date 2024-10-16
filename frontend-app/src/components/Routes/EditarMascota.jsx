import {Lista} from "../Lista.jsx"
import { Nav } from "../Nav.jsx";
import { TbEdit } from "react-icons/tb";
import { camposMascota } from "./camposMascota.js";

export const EditarMascota = () => {


    return (
        <section className="h-full bg-cover bg-center flex flex-col justify-center items-center" style={{ backgroundImage: `url('/public/images/fondo6.jpg')` }}>
            <div className="w-[90%] flex justify-center mt-[0.1%] ">
                <Nav/>
            </div>
            <div className="bg-Blue/50 backdrop-blur-2xl w-[30%] h-[90%] flex flex-col justify-center items-center mt-10 mb-8 py-10 rounded-3xl border border-orange">
                <h1 className="text-3xl text-orange font-medium ">Editar mascota</h1>
                <div className="flex flex-col justify-center items-center">
                    <div>
                        {camposMascota.map((campo, index) => (
                            <div className="flex" key={index}>
                                    <Lista nombreCampo={campo.nombreCampo} tipo={campo.tipo} isImput={campo.isImput} />
                                <button className="">
                                    <TbEdit />
                                </button>
                            </div>
                        ))}
                    </div>
                    <button className="text-2xl text-Newhite mt-10 border rounded-3xl p-2 w-full hover:bg-Blue hover:scale-105 transition-all">
                        Editar Mascota
                    </button>
                </div>
            </div>
        </section>
    )
}

//falta estilar  el icono 