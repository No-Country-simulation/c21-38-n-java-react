import { Link } from "react-router-dom"
import { useLogin } from "../store/login/login";

export const Nav = ({width="w-[70%]", shadow="shadow-lg"}) => {

  const { typeUser, closeSession } = useLogin()

  return (
    <nav className={`h-16 ${width} bg-[#F39C12] rounded-xl flex justify-between items-center pl-5 ${shadow} shadow-black px-10 `}>
      <a href="/"><img src="/images/logo.png" alt="" className="w-16" /></a>

      {typeUser === "" &&(
        <>
        <ul>
          <Link to="/huellitas"><li className="text-3xl text-blue font-semibold">Huellitas</li></Link>
        </ul>
        <ul>
          <Link to="/RegistroUsario" className="text-3xl text-blue font-semibold">Registrarme</Link>
        </ul>
        <ul>
          <Link to="/login" className="text-3xl text-blue font-semibold">Login</Link>
        </ul>
        </>
      )}

      {typeUser === "refugio" && (
        <>
          <ul>
            <Link to="/RegistroMascota" className="text-2xl text-blue font-semibold">Agregar Mascota</Link>
          </ul>
          <ul>
            <Link to="/MiPerfil" className="text-2xl text-blue font-semibold">Perfil Refugio</Link>
          </ul>
          <ul>
            <Link to="/PanelAdopciones" className="text-2xl text-blue font-semibold">Panel de Adopciones</Link>
          </ul>
          <ul>
            <Link className="text-2xl text-blue font-semibold" onClick={() => closeSession()}>Salir</Link>
          </ul>
        </>

      )}
      
      {typeUser == "adoptante" &&(
        <>
          <ul>
            <Link to="/huellitas"><li className="text-3xl text-blue font-semibold">Huellitas</li></Link>
          </ul>
          <ul>
            <Link to="/MiPerfil" className="text-2xl text-blue font-semibold">Mi Perfil</Link>
          </ul>
          <ul>
            <Link to="/MisAdopciones" className="text-2xl text-blue font-semibold">Mis Adopciones</Link>
          </ul>
          <ul>
              <Link className="text-2xl text-blue font-semibold" onClick={() => closeSession()}>Salir</Link>
          </ul>
        </>
      )}


    </nav>
  )
}