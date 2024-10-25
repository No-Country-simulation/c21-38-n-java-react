import { useEffect, useState } from "react";

export const Lista = ({ nombreCampo, tipo, isImput }) => {


  const [valueEspecie, setValueEspecie] = useState("")
  const [controlRaza, setControlRaza] = useState(false)
  const [species, setSpecies] = useState([])
  const [breeds, setBreeds] = useState([])
  const [sizes, setSizes] = useState([])
  const [genders, setGenders] = useState([])

  const handleChangeEspecie = (e) => {
    const value = e.target.value
    setValueEspecie(value)
    setControlRaza(true)
  }

  useEffect(() => {
    const getPetsList = async () => {
      try {
        const response = await fetch('https://c21-38-n-java-react-production.up.railway.app/api/pets/lists')
        const data = await response.json()
        setSpecies(data.body.species)
        setBreeds(data.body.breeds)
        setSizes(data.body.size)
        setGenders(data.body.gender)
      } catch (error) {
        console.log(error)
      }
    }
    getPetsList()
  }, [])

  useEffect(() => {
  }, [valueEspecie])

  return (
    <div className="flex flex-col gap-5">
      {isImput ? (
        tipo === "file" ? (
          <div className=" relative  rounded-2xl text-lg  focus:outline-none curso focus:border-orange">
            <input
              type="file"
              id={nombreCampo}
              name={nombreCampo}
              className="absolute inset-0 w-full  opacity-0 cursor-pointer "
              required
            />
            <button
              type="button"
              className="w-80 h-auto py-2 rounded-2xl text-lg  border bg-Newhite focus:outline-none focus:border-orange"
            >
              Subir {nombreCampo}
            </button>
          </div>
        ) : (
          <input
            type={tipo}
            id={nombreCampo}
            name={nombreCampo}
            placeholder={`Ingresa ${nombreCampo}`}
            className="w-80 h-auto py-2 rounded-2xl text-lg border focus:outline-none focus:border-orange text-center"
            required
          />
        )
      ) : (
        <>
          {
            nombreCampo === "Especie"
            &&

            <select
              name="Especie"
              id=""
              value={valueEspecie}
              onChange={handleChangeEspecie}
              className="w-80 h-auto py-2 rounded-2xl text-lg border focus:outline-none focus:border-orange  text-center"
            >
              <option value="" disabled selected hidden>
                {nombreCampo}
              </option>
              {
                species.map(opt => (
                  <option key={opt.name} value={opt.id}>{opt.name}</option>
                ))
              }
            </select>
          }
          {
            controlRaza &&
            <select
              name="Raza"
              id=""
              className="w-80 h-auto py-2 rounded-2xl text-lg border focus:outline-none focus:border-orange  text-center"
            >
              <option value="" disabled selected hidden>
                {nombreCampo}
              </option>
              {
                breeds.map(opt => (
                  <option key={opt} value={opt.id}>{opt.name}</option>
                ))
              }
            </select>
          }
          {
            nombreCampo === "Genero"
            &&

            <select
              name={nombreCampo}
              id=""
              className="w-80 h-auto py-2 rounded-2xl text-lg border focus:outline-none focus:border-orange  text-center"
            >
              <option value="" disabled selected hidden>
                {nombreCampo}
              </option>
              {
                genders.map(opt => (
                  <option key={opt.name} value={opt.id}>{opt.name}</option>
                ))
              }
            </select>
          }
                    {
            nombreCampo === "Tamaño"
            &&

            <select
              name={nombreCampo}
              id=""
              className="w-80 h-auto py-2 rounded-2xl text-lg border focus:outline-none focus:border-orange  text-center"
            >
              <option value="" disabled selected hidden>
                {nombreCampo}
              </option>
              {
                sizes.map(opt => (
                  <option key={opt.name} value={opt.id}>{opt.name}</option>
                ))
              }
            </select>
          }
        </>
      )}
    </div>
  );
};
