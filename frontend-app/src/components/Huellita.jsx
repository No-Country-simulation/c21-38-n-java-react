
export const Huellita = ({ width, marR, marL, marT ,rot }) => {
    return (
        <img 
            src="/public/images/Huella.svg" 
            style={{
                width: `${width}vh`,
                marginRight: `${marR}vh`,
                marginLeft: `${marL}vh`,
                marginTop: `${marT}vh`,
                transform: `rotate(${rot}deg)`,
            }} 
            className="absolute" 
        />
    );
  };