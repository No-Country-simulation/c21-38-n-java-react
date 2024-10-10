export const Lista = ({ nombreCampo, tipo }) => {
    return (
        <li className="flex flex-col mb-2 ">
            <input
                type={tipo}
                id={nombreCampo}
                name={nombreCampo}
                placeholder={`Ingresa ${nombreCampo}`}
                className="w-80 pl-5 h-auto py-2 rounded-2xl text-lg mt-1 border focus:outline-none focus:border-orange  text-orange" // Añadir borde para mayor visibilidad
                required
            />
        </li>
    );
}
