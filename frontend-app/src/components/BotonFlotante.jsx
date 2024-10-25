import { useState } from "react";
import { RiWhatsappFill } from "react-icons/ri";

import { IoCloseSharp } from "react-icons/io5";
import { MdAddCircle } from "react-icons/md";

import { CrearFormulario } from "./Routes/RutaMascotas/CrearFormularioMascota";


export const BotonFlotante = () => {
    const [size, setSize] = useState({
        width: '25vh', 
        height: '11.3vh', 
        marginLeft: '15px',
        marginBottom: '25px',
        marginRight: '15px',
        
    });
    const [isExpanded, setIsExpanded] = useState(false);
    const [showTitle, setShowTitle] = useState("")

    const toggleSize = () => {
        setSize(prevSize => ({
            width: prevSize.width === '25vh' ? '56vh' : '25vh',
            height: prevSize.height === '11.3vh' ? '90vh' : '11.3vh',
            marginLeft: prevSize.marginLeft === '15px' ? '17vh' : '15px',
            marginRight: prevSize.marginRight === '15px' ? '17vh' : '15px',
            marginBottom: prevSize.marginBottom === '25px' ? '20vh' : '25px'
        }));
        setIsExpanded(prev => !prev);
    };

    const handleMouseEnter = (titulo) =>{
        setShowTitle(titulo);
    }

    const handleMouseLeave = () =>{
        setShowTitle("")
    }

    return (
        <div
            className={`text-7xl flex-col fixed mr-6 mb-8  bottom-4 right-4 p-[2.1vh] shadow-xl z-50 bg-opacity-5 backdrop-blur-3xl transition-all border-2 border-orange  ${isExpanded ? 'rounded-3xl' : 'rounded-full'}`}
            style={{
                width: size.width,
                height: size.height,
                transition: 'width 0.8s ease, height 0.8s ease, margin 0.8s ease'
            }}
        >

            <div className="flex justify-between  bg-red-400 h-0 mb-20">
                {/*boton agregar formulario */}
                <div>
                <button className="hover:scale-110  h-20 transition-all"  onClick={toggleSize}  onMouseEnter={() => handleMouseEnter("Agregar una mascota")} onMouseLeave={handleMouseLeave}>
                    {isExpanded ? (
                            <IoCloseSharp className="text-orange transition-all ml-[15px]" style={{ marginBottom: size.marginBottom }} />
                        ) : (
                            <MdAddCircle className="text-orange transition-all ml-[15px]" style={{ marginBottom: size.marginBottom }} />
                        )}
                    </button>
                </div>
                {/*boton whats */}
                <div className="">
                    <a 
                        href="https://api.whatsapp.com/send?phone=542236979758&text=Me%20gustaria%20adopar%2C%20dame%20mas%20informacion%20%F0%9F%98%87"
                        target="_blank"
                        rel="noopener noreferrer"
                        
                    >
                        <button className="hover:scale-110   transition-all" onMouseEnter={() => handleMouseEnter(isExpanded ? "Cerrar" : "Enviar un mensaje")} onMouseLeave={handleMouseLeave}>
                        <   RiWhatsappFill className="text-green-600 mr-[15px] " style={{ marginBottom:size.marginBottom }} />
                        </button> 
                    </a>
                </div>

            </div>

            {/*Formulario */}



            {showTitle && (
                <div className={`border-2 border-orange text-[20px] flex justify-center items-center p-3 absolute w-[23.6vh] right-[8px] rounded-2xl bg-Blue text-orange transition-all duration-30000
                ${isExpanded ?  "bottom-[82vh] right-[10px] hidden" :  "bottom-32"}
                `} >
                    <h1 >{showTitle}</h1>
                </div>
            )}

        </div>
    );
};