import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { createBrowserRouter, RouterProvider } from 'react-router-dom'
import { Pets } from './components/Routes/Pets.jsx'
import App from './App.jsx'
import './index.css'
import { Home } from './components/Home.jsx'
import { Error } from './components/Routes/Error.jsx'
import { Registre } from './components/Routes/Registre.jsx'
import { Login } from './components/Routes/Login.jsx'
import { RegistroMascota } from './components/Routes/RegistroMascota.jsx'
import { EditarUsuario } from './components/Routes/EditarUsuario.jsx'
import { EditarMascota } from './components/Routes/EditarMascota.jsx'

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
        path:'/Registre',
        element:<Registre/>
      },
      {
        path:'/login',
        element:<Login/>
      },
      {
        path:'/R-Mascota',
        element:<RegistroMascota/>
      },
      {
        path:'/editUser',
        element:<EditarUsuario/>
      },
      {
        path:'/editPet',
        element:<EditarMascota/>
      }
    ]
)

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <RouterProvider router={router}/>
  </StrictMode>,
)
