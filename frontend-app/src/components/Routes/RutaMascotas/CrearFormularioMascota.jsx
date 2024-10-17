import {Lista} from "./Lista.jsx"
import { Nav } from "../../Nav.jsx";
import { camposMascota } from "./camposMascota.js";
import { createPet } from "../../../store/api/createMascota.js";

export const CrearFormulario = ({title, photo}) => {

    const handleSubmit = (event) => {
        event.preventDefault()
        const fields = Object.fromEntries(new window.FormData(event.target))

        const response = createPet(fields)
        console.log(response)

        return
    }

    return (
        <section className="h-full w-full bg-cover bg-center flex flex-col justify-center items-center" 
            style={{ backgroundImage: `url('/public/images/${photo}')` }}
        >
            <div className="w-[90%] flex justify-center mt-[0.1%] ">
                <Nav/>
            </div>

            <div className="bg-Blue/50 backdrop-blur-2xl w-[80%] lg:w-[30%] h-[90%] flex flex-col justify-center items-center mt-10 mb-8 py-10 rounded-3xl border border-orange">
                <h1 className="text-3xl text-orange font-medium mb-5">{title}</h1>

                <form onSubmit={handleSubmit} className="flex flex-col justify-center items-center">
                    <div className="flex flex-col gap-5">
                        {camposMascota.map((campo, index) => (
                            <div className="h-auto" key={index}>
                                    <Lista nombreCampo={campo.nombreCampo} tipo={campo.tipo} isImput={campo.isImput} />
                            </div>
                        ))}
                    </div>
                    <button className="text-2xl text-Newhite mt-10 border rounded-3xl p-2 w-full hover:bg-Blue hover:scale-105 transition-all">
                        {title}
                    </button>
                </form>

            </div>
        </section>
    )
}
