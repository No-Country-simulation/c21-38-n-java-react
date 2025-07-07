import { useEffect, useState } from "react";
import { Nav } from "../Nav"
import { getTokenCookie } from "../../lib/cookiesSession";
import { useLogin } from "../../store/login/login";



export const MisAdopciones = () => {
    const { checkSession } = useLogin()

    const [listPetsAdopters, setListPetsAdopter] = useState([])


    useEffect(() => {
        checkSession()
        const getListPetsAdopter = async () => {
            try {
                const token = getTokenCookie()
                const response = await fetch('https://c21-38-n-java-react-production.up.railway.app/api/pets/adopter/adoptions', {
                    method: 'GET',
                    headers: {
                        "Content-Type": "application/json",
                        "Authorization": `Bearer ${token}`,
                    },
                })
                const data = await response.json()
                console.log(data.body[0].pet.name)
                setListPetsAdopter(data.body)
            } catch (error) {
                console.log(error)
            }
        }
        getListPetsAdopter()

    }, [])

    return (
        <div className="bg-Blue min-h-[100vh] flex flex-col items-center justify-center gap-11">
            <Nav />
            <h1 className="text-4xl text-Newhite mt-12 mb-12">Las adopciones a las que aplicó</h1>
            <div className="flex  w-[69%] justify-center items-center">
                <div className="w-[80%]  flex flex-wrap gap-10 justify-center ">
                    {
                        listPetsAdopters.map(({pet, status}, index) => (
                            <div className="w-72 h-96 flex flex-col border-2  border-orange justify-between items-center rounded-2xl pb-10 hover:scale-110 hover:rotate-6 hover:shadow-2xl hover:shadow-Newhite transition-all" key={index}>
                                <img
                                    src={pet.imageProfile}
                                    alt={`Slide ${pet.name}`}
                                    className="w-full h-52 rounded-3xl object-cover p-4"
                                />
                                <div className="w-[86%] h-1 rounded-full bg-Blue"></div>
                                <div className="bg-Newhite p-5 pt-1 rounded">
                                    <p className="text-center text-Blue text-2xl font-bold pt-5 ">{pet.name}</p>
                                    <p className="text-center text-Blue text-2xl font-bold ">Estado: {status === "IN_PROCESS" ? "En Proceso" : "Aceptado, comuniquese con el refugio"}</p>
                                </div>
                            </div>
                        ))
                    }
                </div>
            </div>

        </div>
    );
};
