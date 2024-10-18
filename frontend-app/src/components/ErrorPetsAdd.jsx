import './checkPetAdd.css'

export const ErrorPetAdd = () =>{
    return(
        <div className="4xl text-Blue flex animate-slideUp">
        <div className="bg-orange w-[48vh] flex justify-end items-center h-24 p-5 rounded-3xl border-8 border-Blue">
            <div className=" h-20 w-20 mr-9 rounded-full relative">
                <img src="/public/images/error.svg " alt="" className="w-12 mt-4 ml-4 "/>
            </div>
            <h3 className="text-3xl mr-2 text-Blue">Error al cargar la mascota</h3>
        </div>
        </div>
    )
}