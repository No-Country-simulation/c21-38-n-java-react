import './checkPetAdd.css'

export const Check= () =>{
    return(
        <div className="4xl text-Newhite flex animate animate-slideUp">
            <div className="bg-Blue w-[40vh] flex justify-end items-center h-24 p-5 rounded-3xl border-4 border-orange">
                <div className="bg-orange h-20 w-20 mr-9 rounded-full relative">
                    <img src="/public/images/check.svg" alt="" className="w-12 mt-4 ml-4 "/>
                </div>
                <h3 className="text-3xl mr-2 text-Newhite">Mascota Agregada</h3>
            </div>
        </div>
    )
}