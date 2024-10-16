import { Formulario } from "../Formulario"
import { Nav } from "../Nav"
import { useFormulario } from "./UserFormulario";


export const EditarUsuario = () =>{
    const { isFormActive, isAdoptante, toggleActiveForm, toggleIsAdoptante, toggleRefugio } = useFormulario();


    const preguntasAdoptante = [
        { texto: 'Nombre de usario', tipo:'text' },
        { texto: 'Correo Electrónico', tipo:'email' },
        { texto: 'Contraseña', tipo:'password'},
        {texto: 'Repetir Contraseña', tipo:'password'},
        {texto: 'Direccion',tipo:'text'},
        {texto: 'Telefono', tipo:'number'}
    ];
    
    const preguntasVeterinaria = [
        { texto: 'Nombre del establecimiento' },
        { texto: 'Quit del establecimiento' },
        {texto: 'Contraseña'},
        {texto:'Repetir Contraseña'},
        {texto: 'Direccion del establecimiento'},
        {texto: 'Telefono del establecimiento'}
    ];

    return(
        <main className={`p-10  bg-cover ${isFormActive ? "h-full" : "h-screen"} bg-center flex flex-col justify-center items-center`} style={{ backgroundImage: `url('/public/images/fondo5.jpg')` }}>
            
            <Nav/>

            <div className="flex w-[50%] gap-20">
                    <button type="submit" className="w-full  mt-9 text-xl border bg-Blue text-white p-2 rounded-md hover:bg-orange hover:text-Blue hover:scale-[101%]" onClick={() => { toggleIsAdoptante();toggleActiveForm(); }}>
                        Soy un Adoptante
                    </button>
                    <button type="submit" className="w-full  mt-9 text-xl border bg-Blue text-white p-2 rounded-md hover:bg-orange hover:text-Blue hover:scale-[101%] " onClick={() => { toggleRefugio();toggleActiveForm(); }}>
                        Soy un Refugio
                    </button>

            </div>

            {isFormActive && (<Formulario titulo={"Editar usuario"} preguntas={isAdoptante? preguntasAdoptante : preguntasVeterinaria} />)}

        </main>
    )
}