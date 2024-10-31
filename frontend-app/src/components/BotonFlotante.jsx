import { RiWhatsappFill } from "react-icons/ri";



export const BotonFlotante = () => {

    return (
        <div
            className={`text-7xl flex-col fixed mb-8  right-4 p-[2.1vh] h-0 z-50 rounded-full items-center bottom-16 mr-20`}
        >
            {/*boton whats */}
            <div className="">
                <a 
                    href="https://api.whatsapp.com/send?phone=542236979758&text=Me%20gustaria%20adopar%2C%20dame%20mas%20informacion%20%F0%9F%98%87"
                    target="_blank"
                    rel="noopener noreferrer"
                    
                >
                    <button className="hover:scale-110   transition-all" >
                    <   RiWhatsappFill className="text-green-600 left-8 w-24 h-24 "  />
                    </button> 
                </a>
            </div>
        </div>
    );
};