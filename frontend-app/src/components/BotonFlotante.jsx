import { useState } from "react";
import { RiWhatsappFill } from "react-icons/ri";
import { TbMessageChatbotFilled } from "react-icons/tb";
import { IoCloseSharp } from "react-icons/io5";
import { MdAddCircle } from "react-icons/md";
import { Lista } from "./Lista";

export const BotonFlotante = () => {
    const [size, setSize] = useState({
        width: '56vh', // devolver a 25vh
        height: '90vh', //devolver a 12
        marginLeft: '15px',
        marginBottom: '25px',
        marginRight: '15px',
    });
    const [isExpanded, setIsExpanded] = useState(false);

    const toggleSize = () => {
        setSize(prevSize => ({
            width: prevSize.width === '56vh' ? '56vh' : '56vh',//devolver a 25 
            height: prevSize.height === '90vh' ? '90vh' : '90vh',//devolver a 12
            marginLeft: prevSize.marginLeft === '15px' ? '17vh' : '15px',
            marginRight: prevSize.marginRight === '15px' ? '17vh' : '15px',
            marginBottom: prevSize.marginBottom === '25px' ? '20vh' : '25px'
        }));
        setIsExpanded(prev => !prev);
    };

    return (
        <div
            className={`text-7xl flex-col fixed mr-6 mb-8  bottom-4 right-4 p-5 shadow-xl z-50 bg-opacity-5 backdrop-blur-3xl transition-all border-2 border-orange  ${isExpanded ? 'rounded-3xl' : 'rounded-3xl'}`}//rounded-full
            style={{
                width: size.width,
                height: size.height,
                transition: 'width 0.8s ease, height 0.8s ease, margin 0.8s ease'
            }}
        >

            <div className="flex justify-between  bg-red-400 h-0 mb-20">
                {/*boton agregar formulario */}
                <div>
                    <button className="hover:scale-110  transition-all" onClick={toggleSize} >
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
                        <button className="hover:scale-110   transition-all">
                        <   RiWhatsappFill className="text-green-600 mr-[15px] " style={{ marginBottom:size.marginBottom }} />
                        </button> 
                    </a>
                </div>

            </div>

            {/*Formulario */}

            <div className={`bg-Blue rounded-2xl h-[90%] overflow-auto p-4 flex-col justify-center items-center ${isExpanded ? 'hidden' : 'flex-col'}`} style={{transition: 'width 0.8s ease, height 0.8s ease, margin 0.8s ease'}}> {/* overflow-auto permite el scroll si el contenido es mayor */}
                <form action="" className="flex w-full flex-col gap-4 justify-center items-center">
                    <ul className="flex flex-col gap-8">
                        <Lista nombreCampo={"Nombre"} tipo={"text"}/>
                        <Lista nombreCampo={"Especie"} tipo={"text"}/>
                        <Lista nombreCampo={"Raza"} tipo={"text"}/>
                        <Lista nombreCampo={"Edad"} tipo={"text"}/>
                        <Lista nombreCampo={"Genero"} tipo={"text"}/>
                        <Lista nombreCampo={"Tamaño"} tipo={"text"}/>
                        <Lista nombreCampo={"Estado de salud"} tipo={"text"}/>
                    </ul>
                    <button className="text-xl text-Newhite ">
                        Agregar
                    </button>
                </form>
            </div>
        </div>
    );
};


