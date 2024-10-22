import { Link } from "react-router-dom"
import { Nav } from "../Nav"

export const Login = () =>{
    return(
        <main className="h-screen bg-cover bg-center flex flex-col justify-center items-center" style={{ backgroundImage: `url('/public/images/gatowallpaper.jpg` }} >
            <div className="w-[90%] flex justify-center mt-[-10%] mb-16">
                <Nav/>
            </div>

    <form className="bg-Blue/50 backdrop-blur-2xl h-[60%] w-[45%] rounded-2xl px-52 text-Newhite flex flex-col justify-center mt-14 border-2 border-orange">
    <h2 className="text-3xl mb-10 text-center font-medium">Iniciar Sesion</h2>

    <div className="mb-10 text-lg">
        <label htmlFor="email" className="block text-lg font-medium ">Correo Electrónico</label>
        <input
            type="email"
            id="email"
            required
            className="mt-1 block w-full p-2 border border-gray-300 text-Blue rounded-md"
        />
    </div>

    <div className="mb-6 text-lg">
        <label htmlFor="password" className="block text-lg font-medium ">Contraseña</label>
        <input
            type="password"
            id="password"
            required
            className="mt-1 block w-full p-2 border border-gray-300 text-Blue rounded-md"
        />
    </div>


    <button type="submit" className="w-full  mt-9 text-xl border bg-Blue text-white p-2 rounded-md hover:bg-orange hover:text-Blue hover:scale-[101%]">
        Iniciar Sesion
    </button>

    <section className="flex justify-between">
        <div className="mt-8 hover:scale-105">
            <Link to="/registre" >Registrarme</Link>
        </div>

        <div className="mt-8 hover:scale-105">
            <a                     
                href="https://wa.link/30fmvu"
                target="_blank"
                rel="noopener noreferrer"        
            >Olvide mi contraseña</a>
        </div>
    
    </section>
        

</form>
        </main>
    )
}