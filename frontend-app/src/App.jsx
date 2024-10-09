import { Header } from "./components/Header"
import { Footer } from "./components/Footer"

import { BotonFlotante } from "./components/BotonFlotante"

function App({children}) {
  return (
    <>
      <Header/>

      <main className="w-full h-auto flex-col  justify-center bg-[#F8F9FA] ">
        {children}
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