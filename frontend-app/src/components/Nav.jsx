import { Link } from "react-router-dom"

export const Nav = ({width="w-[70%]", shadow="shadow-lg"}) => {
  return (
    <nav className={`h-16 ${width} bg-[#F39C12] rounded-xl flex justify-between items-center pl-5 ${shadow} shadow-black px-10 `}>
      <a href="/"><img src="/images/logo.png" alt="" className="w-16" /></a>
      
      <ul>
        <Link to="/huellitas"><li className="text-3xl text-blue font-semibold">Huellitas</li></Link>
      </ul>

      <ul>
        <Link to="/RegistroUsario" className="text-3xl text-blue font-semibold">Registrarme</Link>
      </ul>

      <ul>
        <Link to="/login" className="text-3xl text-blue font-semibold">Login</Link>
      </ul>

    </nav>
  )
}