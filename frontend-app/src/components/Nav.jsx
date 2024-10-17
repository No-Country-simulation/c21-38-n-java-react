import { Link } from "react-router-dom"

export const Nav = () => {
  return (
    <nav className="w-[70%] h-16 bg-[#F39C12] rounded-xl flex justify-between items-center pl-3 shadow-lg shadow-black px-10 ">
      <a href="/"><img src="/images/logo.png" alt="" className="w-16" /></a>
      <ul>
        <Link to="/huellitas"><li className="text-2xl text-blue font-semibold">Huellitas</li></Link>
      </ul>

      <ul>
        <Link to="/RegistroUsario" className="text-2xl text-blue font-semibold">Registrarme</Link>
      </ul>

      <ul>
        <Link to="/login" className="text-2xl text-blue font-semibold">Login</Link>
      </ul>

      <ul>
        <Link to="/RegistroMascota" className="text-2xl text-blue font-semibold">Agregar Mascota</Link>
      </ul>
    </nav>
  )
}