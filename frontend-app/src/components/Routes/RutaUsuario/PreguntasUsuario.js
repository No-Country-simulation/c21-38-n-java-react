export const preguntasAdoptante = [
  { texto: "Nombre de Usuario", name: "name", tipo: "text" },
  { texto: "Apellido", name: "lastname", tipo: "text" },
  { texto: "Correo Electrónico", name: "email", tipo: "email" },
  { texto: "Dirección", name: "country", tipo: "text" },
  { texto: "Teléfono", name: "cellphoneNumber", tipo: "text" },
  { texto: "Fecha de Nacimiento", name: "birthDate", tipo: "date" },
  {
    texto: "Estado Civil",
    name: "civilStatus",
    tipo: "select",
    options: [
      { name: "Soltero", value: "SINGLE" },
      { name: "Casado", value: "MARRIED" },
      { name: "Union Libre", value: "FREE_UNION" },
    ],
  },
  { texto: "Mascotas Actuales", name: "actualPets", tipo: "number" },
  { texto: "Miembros de la Familia", name: "familyMembers", tipo: "number" },
  { texto: "Razón para Adoptar", name: "adoptionReason", tipo: "text" },
  {
    texto: "Tiempo Diario Disponible en Horas",
    name: "dailyTimeAvailable",
    tipo: "number",
  },
  { texto: "Tipo de Vivienda", name: "houseType", tipo: "select",
    options: [
      { name: "Casa", value: "HOUSE" },
      { name: "Cabaña", value: "CABAIN" },
      { name: "Apartamento", value: "APARTMENT" },
    ],
  },
  { texto: "Extensión de la Vivienda en m²2", name: "houseExtension", tipo: "number" },
  { texto: "Tipo de Identificación", name: "identificationType", tipo: "select",
    options: [
      { name: "Cedula de Ciudadania", value: "CC" },
      { name: "Cedula de Extrangeria", value: "CE" },
      { name: "Tarjeta de Identidad", value: "TI" },
    ],
  },
  {
    texto: "Número de Identificación",
    name: "identificationNumber",
    tipo: "number",
  },
  { texto: "Ciudad", name: "city", tipo: "text" },
  { texto: "¿Tuvo mascotas antes? (Si/No)", name: "imageProfile", tipo: null },
  { texto: "Contraseña", name: "password", tipo: "password" },
];

export const preguntasVeterinaria = [
  { texto: "Nombre del refugio", name: "name", tipo: "text" },
  { texto: "Capacidad Máxima", name: "maxCapacity", tipo: "number" },
  { texto: "Registro Legal", name: "legalRegistration", tipo: "text" },
  { texto: "Correo Electrónico", name: "email", tipo: "email" },
  { texto: "Contraseña", name: "password", tipo: "password" },
  // { texto: "Rol", name: "role", tipo: "text" },
  { texto: "Teléfono", name: "cellphoneNumber", tipo: "text" },
  { texto: "¿Tiene una unica sucursal? (Si/No)", name: "imageProfile", tipo: null },
  { texto: "País", name: "country", tipo: "text" },
  { texto: "Ciudad", name: "city", tipo: "text" },
];
