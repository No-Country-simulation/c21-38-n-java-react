import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { createBrowserRouter, RouterProvider } from 'react-router-dom'
import App from './App.jsx'
import './index.css'
import { Home } from './components/Home.jsx'
import { Error } from './components/Routes/RutaError/Error.jsx'
import { RegistrarUsuario } from './components/Routes/RutaUsuario/RegistrarUsuario.jsx'
import { Login } from './components/Routes/Login.jsx'
import { RegistroMascota } from './components/Routes/RutaMascotas/RegistroMascota.jsx'
import { EditarUsuario } from './components/Routes/RutaUsuario/EditarUsuario.jsx'
import { EditarMascota } from './components/Routes/RutaMascotas/EditarMascota.jsx'
import { Pets } from './components/Routes/mascotas/Pets.jsx'
import { MiPerfil } from './components/Routes/Pefil/MiPerfil.jsx'

const router=createBrowserRouter(
    [
      {
        path:'/',
        element:<App/>,
        children:[
          {
            path:'/',
            element:<Home/>
          },
          {
            path:'/huellitas',
            element:<Pets/>
          },
        ]
      },
      {
        path:'/error',
        element:<Error/>
      },
      {
        path:'/RegistroUsario',
        element:<RegistrarUsuario/>
      },
      {
        path:'/login',
        element:<Login/>
      },
      {
        path:'/RegistroMascota',
        element:<RegistroMascota/>
      },
      {
        path:'/editUser',
        element:<EditarUsuario/>
      },
      {
        path:'/editPet',
        element:<EditarMascota/>
      },
      {
        path:'/MiPerfil',
        element:<MiPerfil/>
      }
    ]
)

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <RouterProvider router={router}/>
  </StrictMode>,
)
