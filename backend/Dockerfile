# Etapa 1: Build
FROM ubuntu:latest AS build

# Actualizar paquetes y instalar dependencias necesarias
RUN apt-get update && apt-get install -y \
    openjdk-11-jdk \
    maven \
    git \
    && rm -rf /var/lib/apt/lists/*

# Establecer la variable de entorno para Java
ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH

# Crear el directorio de trabajo
WORKDIR /app

# Copiar el archivo pom.xml y descargar las dependencias del proyecto
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el código fuente del proyecto
COPY src ./src

# Construir el proyecto con Maven, omitiendo los tests
RUN mvn clean package -DskipTests

# Etapa 2: Runtime
FROM ubuntu:latest

# Instalar OpenJDK 11
RUN apt-get update && apt-get install -y \
    openjdk-11-jre \
    && rm -rf /var/lib/apt/lists/*

# Establecer la variable de entorno para Java
ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH

# Exponer el puerto en el que la aplicación estará escuchando
EXPOSE 8080

# Copiar el archivo JAR generado desde la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
