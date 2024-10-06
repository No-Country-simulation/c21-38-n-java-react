import React, { useEffect, useState } from 'react';



export const SobreNosotros=()=>{

    const [visible, setVisible] = useState(false);

    useEffect(() => {
        
        const timer = setTimeout(() => {
            setVisible(true);
        }, 1000); 

        return () => clearTimeout(timer); 
    }, []);

    return(
<section className={`bg-[#1F485C] flex w-full h-[403px] items-center transition-opacity duration-1000 ${visible ? 'opacity-100' : 'opacity-0'}`}>
    <div className='pl-52 flex relative'>
        <div className='flex-shrink-0'>
            <img 
                src="/public/images/chica-y-gato.jpg" 
                style={{ transform: 'rotate(-4deg)' }}
                className='w-60 h-72 rounded-3xl object-cover border-8 border-[#F39C12]' 
            />
        </div>

        <div className='flex-shrink-0 absolute w-32' style={{ top: '5%', left: '90%' }}> {/* Ajusta según sea necesario */}
            <img 
                src="/public/images/PerroPrimerPlano.jpg" 
                style={{ transform: 'rotate(5deg)' }}
                className='h-40 rounded-3xl object-cover border-4 border-[#F8F9FA]  ' 
            />
        </div>
    </div>

    <div>
        {/* Aquí puedes agregar más contenido si es necesario */}
    </div>
</section>
    )
}