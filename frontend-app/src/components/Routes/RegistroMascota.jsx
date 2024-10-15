import { useState } from "react";
import {Lista} from "../Lista.jsx"

export const RegistroMascota = () => {


    return (
        <div>
            <Lista nombreCampo={"Nombre"} tipo={"text"} isImput={1}/>
            <Lista nombreCampo={"Especie"} tipo={"text"} isImput={1}/>
            <Lista nombreCampo={"Raza"} tipo={"text"} isImput={1}/>
            <Lista nombreCampo={"Edad"} tipo={"text"} isImput={1}/>
            <Lista nombreCampo={"Genero"} tipo={"text"} isImput={0}/>
            <Lista nombreCampo={"Tamaño"} tipo={"text"} isImput={1}/>
            <Lista nombreCampo={"Estado de salud"} tipo={"text"} isImput={1}/>
            <Lista nombreCampo={"Foto"} tipo={"file"} isImput={1} />
        </div>
    )
}

