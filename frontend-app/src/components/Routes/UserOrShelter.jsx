import { useFormulario } from "./UserFormulario";

export const UserOrShelter = () =>{

    const {toggleActiveForm, toggleIsAdoptante, toggleRefugio } = useFormulario();

    return(
        
        <div className="flex w-[50%] gap-20">
            <button type="submit" className="w-full  mt-9 text-xl border bg-Blue text-white p-2 rounded-md hover:bg-orange hover:text-Blue hover:scale-[101%]" onClick={() => { toggleIsAdoptante();toggleActiveForm(); }}>
                Soy un Adoptante
            </button>
            <button type="submit" className="w-full  mt-9 text-xl border bg-Blue text-white p-2 rounded-md hover:bg-orange hover:text-Blue hover:scale-[101%] " onClick={() => { toggleRefugio();toggleActiveForm(); }}>
                Soy un Refugio
            </button>

        </div>
    )
}