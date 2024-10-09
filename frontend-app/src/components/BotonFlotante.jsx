import { useState } from "react";
import { RiWhatsappFill } from "react-icons/ri";
import { TbMessageChatbotFilled } from "react-icons/tb";
import { IoCloseSharp } from "react-icons/io5";

export const BotonFlotante = () => {
    const [size, setSize] = useState({
        width: '25vh',
        height: '12vh',
        marginLeft: '15px',
        marginBottom: '25px',
        marginRight: '15px',
    });
    const [isExpanded, setIsExpanded] = useState(false);

    const toggleSize = () => {
        setSize(prevSize => ({
            width: prevSize.width === '25vh' ? '56vh' : '25vh',
            height: prevSize.height === '12vh' ? '80vh' : '12vh',
            marginLeft: prevSize.marginLeft === '15px' ? '17vh' : '15px',
            marginRight: prevSize.marginRight === '15px' ? '17vh' : '15px',
            marginBottom: prevSize.marginBottom === '25px' ? '20vh' : '25px'
        }));
        setIsExpanded(prev => !prev);
    };

    return (
        <div
            className={`text-7xl flex fixed mr-6 mb-8 justify-between bottom-4 right-4 p-5 shadow-xl z-50 bg-opacity-5 backdrop-blur-3xl transition-all border-2 border-orange  ${isExpanded ? 'rounded-3xl' : 'rounded-full'}`}
            style={{
                width: size.width,
                height: size.height,
                transition: 'width 0.8s ease, height 0.8s ease, margin 0.8s ease'
            }}
        >
            <div>
                <button className="hover:scale-110  transition-all" onClick={toggleSize} >
                {isExpanded ? (
                        <IoCloseSharp className="text-orange transition-all ml-[15px]" style={{ marginBottom: size.marginBottom }} />
                    ) : (
                        <TbMessageChatbotFilled className="text-orange transition-all ml-[15px]" style={{ marginBottom: size.marginBottom }} />
                    )}
                </button>
            </div>

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
    );
};


