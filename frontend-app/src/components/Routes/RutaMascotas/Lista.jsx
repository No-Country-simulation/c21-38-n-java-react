import { useEffect, useState } from "react";

export const Lista = ({ nombreCampo, tipo, isImput }) => {
  const optionsEspecie = [
    { name: "Perro", value: "DOG" },
    { name: "Gato", value: "CAT" }
  ]

  const optionsRaza = {
    "CAT": ["Persa", "Muchi", "Bles"],
    "DOG": ["Border Collie", "Pitbull", "Dalmata", "Pincher", "Rodwailler"]
  }

  const optionsGender = [
    { name: "Macho", value: "M" },
    { name: "Hembra", value: "H" },
  ]

  const optionsSize = [
    { name: "Pequeño", value: "P" },
    { name: "Mediano", value: "M" },
    { name: "Grande", value: "G" },

  ]


  const [listEspecies, setListEspecies] = useState([])
  const [valueEspecie, setValueEspecie] = useState("")
  const [controlRaza, setControlRaza] = useState(false)

  const handleChangeEspecie = (e) => {
    const value = e.target.value
    setValueEspecie(value)
    setListEspecies(optionsRaza[value])
    setControlRaza(true)
  }

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
                optionsEspecie.map(opt => (
                  <option key={opt.name} value={opt.value}>{opt.name}</option>
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

                listEspecies.map(opt => (
                  <option key={opt} value={opt}>{opt}</option>
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

                optionsGender.map(opt => (
                  <option key={opt.name} value={opt.value}>{opt.name}</option>
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

                optionsSize.map(opt => (
                  <option key={opt.name} value={opt.value}>{opt.name}</option>
                ))
              }
            </select>
          }
        </>
      )}
    </div>
  );
};
