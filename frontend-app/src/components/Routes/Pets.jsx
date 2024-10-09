import { useEffect } from "react"

export const Pets=()=>{
    useEffect(()=>{
        console.log("text")
    },[])

    return(
        <div >
            <h1>Listado de mascotas</h1>
        </div>
    )
}