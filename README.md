# 💻 Portfolio Web - #YoProgramo
![GitHub Release Date](https://img.shields.io/github/release-date/mariquenaallosa/portfolio-backend) ![GitHub followers](https://img.shields.io/github/followers/mariquenaallosa?style=social)

*NOTA: En este repositorio se encuentra todo lo relacionado al **Backend** del proyecto, para dirigirse al repositorio del **Frotend** **[hacer click aquí](https://github.com/mariquenaallosa/portfolio-frontend).***
## 📝 Descripción
- ***Backend** del **Portfolio Web Fullstack*** realizado como Proyecto Final del curso **Argentina Programa - #YoProgramo**.

- Se trata de una **API REST** realizada utilizando las tecnologías **Java + Spring Boot** bajo el modelo **MVC** para la lógica y **MySQL** para persistencia de datos.

- A continuación se incluye el **Diagrama Entidad - Relación** (DER) utilizado en la Base de Datos Relacional y que posteriormente se traduce en los Modelos o Entidades del Backend:

<div align="center">

</div>

## ✅ Como utilizar la API
**Proximamente**
## ⌨🖱 Instalación
- Si queremos correr la aplicación en un entorno local debemos tener en cuenta lo siguiente: 

1. Clonar el repositorio utilizando GIT o descargando el archivo ZIP:

    `https://github.com/mariquenaallosa/portfolio-backend.git`

2. Instalar las dependencias de Maven utilizando nuestro IDE preferido o a través del comando:

    `mvn install`

3. Crear/Configurar el archivo _application.properties_ en src/main/resources/

```properties
spring.jpa.hibernate.ddl-auto = update
spring.datasource.url = jdbc:mysql://<host_DB>:<puerto_DB>/<nombre_DB>?serverTimezone=UTC&createDatabaseIfNotExist=true
spring.datasource.username = <usuario>
spring.datasource.password= <contraseña>
spring.jpa.database-platform = org.hibernate.dialect.MySQL8Dialect
portfolio.jwtSecret = <clave_alfanumérica_JWT>
portfolio.jwtExpirationMs = <tiempo_expiración_JWT> 
```
NOTA: Reemplazar los valores borrando los <>.

4. Ejecutar nuestra aplicación iniciando el archivo `PortfolioApplication.Java` o bien ejecutando el siguiente comando:
    `mvn sprin-boot:run`

## 📩 Contacto
🙋🏻‍♀️ Si tienes dudas podés hacerlo a través de: **[LinkedIn](https://www.linkedin.com/in/mariquenaallosa/) **
