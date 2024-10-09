# Etapa 1: Construcción
FROM maven:3.8.5-openjdk-17-slim AS build

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo pom.xml y el directorio src
COPY pom.xml .
COPY src ./src

# Ejecuta Maven para compilar la aplicación y crear el JAR
RUN mvn clean package -DskipTests

# Etapa 2: Crear la imagen final
FROM openjdk:17-jdk-slim

# Copia el JAR construido al contenedor
COPY --from=build /app/target/shelter-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que la aplicación escuchará
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
