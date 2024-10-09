import { Header } from "./components/Header"
import { Footer } from "./components/Footer"

import { BotonFlotante } from "./components/BotonFlotante"
import { Outlet } from "react-router-dom"

function App() {
  return (
    <>
      <Header/>

      <main className="w-full h-auto flex-col  justify-center bg-[#F8F9FA] ">
        <Outlet />
      </main>
      <footer>
        <Footer/>
      </footer>

      <div className="">
        <BotonFlotante/>
      </div>
    </>
  )
}

export default App