import { Check } from "../../checkPetAdd"
import { ErrorPetAdd } from "../../ErrorPetsAdd"
import { CrearFormulario } from "./CrearFormularioMascota"

export const RegistroMascota = () => {

    return(
        <section className="flex flex-col justify-center ">
            <CrearFormulario title="Registrar Mascota" photo="tresPerritos.jpg"/>

        </section>
    )
}