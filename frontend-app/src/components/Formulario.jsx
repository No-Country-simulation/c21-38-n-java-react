import { Link } from "react-router-dom";

export const Formulario = ({ preguntas }) => { 

    return (
        <form className="bg-Blue/50 backdrop-blur-2xl h-full w-[50%] rounded-2xl px-52 text-Newhite flex flex-col justify-center mt-14 border-2 border-orange py-10">
            {preguntas.map((pregunta, index) => ( // Usa paréntesis para devolver JSX
                <div key={index} className="mb-6 text-lg">
                    <label className="block text-lg font-medium">{pregunta.texto}</label>
                    <input 
                        type={pregunta.tipo} 
                        className="mt-1 block w-full p-2 border border-gray-300 text-Blue rounded-md" 
                    />
                </div>
            ))} 

            <button 
                type="submit" 
                className="w-full mt-9 text-xl border bg-Blue text-white p-2 rounded-md hover:bg-orange hover:text-Blue hover:scale-[101%]"
            >
                <Link to="/login">Registrase</Link>
            </button>
        </form>
    );
};
