import { useEffect, useState } from "react";
import { Carousel } from "./Carousel";
import { Nav } from "../Nav"
import { getTokenCookie } from "../../lib/cookiesSession";
import { useLogin } from "../../store/login/login";


const slides = [
    // Acá irían las imágenes que saquemos del back
    "./../../../public/images/cachorrog1.jpg",
    "./../../../public/images/cachorrog2.jpg",
    "./../../../public/images/cachorrog3.jpg",
    "./../../../public/images/cachorrog5.jpg",
];

const infoSlides = [
    // Acá iría la descripción
    "Información sobre cachorrog1",
    "Información sobre cachorrog2",
    "Información sobre cachorrog3",
    "Información sobre cachorrog5",
];

export const MisAdopciones = () => {
    const { checkSession } = useLogin()
    const [currentSlide, setCurrentSlide] = useState(0);
    const [listPetsAdopters, setListPetsAdopter] = useState([])
    const handleSlideChange = (newIndex) => {
        setCurrentSlide(newIndex);
    };

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
            <div className="flex justify-center items-center">
                <div className="w-full h-auto flex flex-wrap gap-10">
                    {
                        listPetsAdopters.map(({pet, status}, index) => (
                            <div className="w-72 h-72 flex flex-col border-2 border-white justify-between items-center" key={index}>
                                <img
                                    src={pet.imageProfile}
                                    alt={`Slide ${pet.name}`}
                                    className="w-full h-auto object-cover"
                                />
                                <p className="text-center text-Newhite text-2xl ">{pet.name}</p>
                                <p className="text-center text-Newhite text-2xl ">Estado: {status === "IN_PROCESS" ? "En Proceso" : "Aceptado"}</p>
                            </div>
                        ))
                    }
                </div>
                {/* <div className="max-w-xl p-10">
                    <Carousel
                        autoSlide={true}
                        autoSlideInterval={10000}
                        onSlideChange={handleSlideChange}
                    >
                        {listPetsAdopters.map((s, index) => (
                            <div className="w-72 h-72 flex flex-row-reverse" key={index}>
                                <p className="text-center text-lg text-Newhite">{s.pet.name}</p>
                                <img
                                    src={s.pet.imageProfile}
                                    alt={`Slide ${s.pet.name}`}
                                    className="w-36 h-36 object-cover rounded-full"
                                    />
                            </div>
                        ))}
                    </Carousel>
                </div> */}
            </div>

        </div>
    );
};
