import { Link, useNavigate } from "react-router-dom"
import { Nav } from "../Nav"
import { useLogin } from "../../store/login/login"
import { useState } from "react"

export const Login = () => {

  const navigate = useNavigate()
  const [userInfo, setUserInfo] = useState({
    email: "",
    password: "",
  });

  const handleChange = (e, type) => {
    const { name, value } = e.target;
    let setValue = value
    if (type === "number") {
      setValue = parseInt(value)
    }
    setUserInfo((prevInfo) => ({
      ...prevInfo,
      [name]: setValue,
    }));
  };



  const handleSubmit = async (e) => {
    e.preventDefault()
    try {
      const response = await fetch( "https://c21-38-n-java-react-production.up.railway.app/api/auth/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(userInfo),
      });
      console.log(response)
      if (response.status === 200) {
        const data = await response.json();
        console.log("ingreso validado:", data);
        navigate('/')
        // Aquí puedes manejar la respuesta del servidor
      } else {
        console.error("Error al consultar usuario:", response.status);
      }
    } catch (error) {
      console.error("Error en la solicitud:", error);
    
    }
  };



    //_______________________________

  return (
    <main className="h-screen bg-cover bg-center flex flex-col justify-center items-center" style={{ backgroundImage: `url('/public/images/gatowallpaper.jpg` }} >
      <div className="w-[90%] flex justify-center mt-[-10%] mb-16">
        <Nav />
      </div>

      <form onSubmit={handleSubmit} className="bg-Blue/50 backdrop-blur-2xl h-[60%] w-[45%] rounded-2xl px-52 text-Newhite flex flex-col justify-center mt-14 border-2 border-orange">
        <h2 className="text-3xl mb-10 text-center font-medium">Iniciar Sesion</h2>

        <div className="mb-10 text-lg">
          <label htmlFor="email" className="block text-lg font-medium ">Correo Electrónico</label>
          <input
            name="email"
            type="email"
            id="email"
            required
            onChange={(e) => handleChange(e)}
            className="mt-1 block w-full p-2 border border-gray-300 text-Blue rounded-md"
          />
        </div>

        <div className="mb-6 text-lg">
          <label htmlFor="password" className="block text-lg font-medium ">Contraseña</label>
          <input
            name="password"
            type="password"
            id="password"
            required
            onChange={(e) => handleChange(e)}
            className="mt-1 block w-full p-2 border border-gray-300 text-Blue rounded-md"
          />
        </div>


        <button className="w-full  mt-9 text-xl border bg-Blue text-white p-2 rounded-md hover:bg-orange hover:text-Blue hover:scale-[101%]">
          Iniciar Sesion
        </button>
      </form>
      
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
    </main>
  )
}