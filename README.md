# Paticas API

Paticas API es un servicio web RESTful para la gestión de mascotas y refugios. Soporta operaciones CRUD para mascotas, refugios y voluntarios. La API también proporciona funcionalidad de carga de archivos para gestionar imágenes de mascotas.
## Tabla de contenidos

- [Paticas API](#paticas-api)
  - [Tabla de contenidos](#tabla-de-contenidos)
  - [Features](#features)
  - [Tecnologías Usadas](#tecnologías-usadas)
  - [Getting Started](#getting-started)
    - [Prerrequisitos](#prerrequisitos)
    - [Setup](#setup)
  - [Documentación de la API](#documentación-api)
  - [Endoints](#endoints)
    - [Pets](#pets)
    - [Shelters](#shelters)
    - [Volunteers](#volunteers)


## Features

- Operaciones CRUD para Pets
- Operaciones CRUD para Shelters
- Operaciones CRUD para Volunteers
- Subida de imágenes de Pets
- Filtrado y paginado por Pets
- Documentación Swagger

## Tecnologías Usadas

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Gradle
- Swagger

## Getting Started

### Prerrequisitos

- Java 11 o superior
- MySQL
- Gradle

### Setup

1. Clonar el repositorio:

```bash
git clone https://github.com/mychemicalEli/paticas-api.git
cd paticas-api
```

2. Configurar la base de datos en MySQL:

  ```yml
# Use root/example as user/password credentials
version: '3.1'

services:

  db:
    image: mysql:8.0.32
    # NOTE: use of "mysql_native_password" is not recommended: https://dev.mysql.com/doc/refman/8.0/en/upgrading-from-previous-series.html#upgrade-caching-sha2-password
    # (this is just an example, not intended to be a production configuration)
    command: --default-authentication-plugin=mysql_native_password
    restart: always
    ports:
      - "3306:3306"
    environment:
      MYSQL_ROOT_PASSWORD: mypassword
      MYSQL_DATABASE: paticasdb
      MYSQL_USER: myuser
      MYSQL_PASSWORD: mypassword
    volumes:
      - db_data:/var/lib/mysql
      
  adminer:
<!-- @import "[TOC]" {cmd="toc" depthFrom=1 depthTo=6 orderedList=false} -->

    image: adminer
    restart: always
    ports:
      - 8080:8080
      
volumes:
  db_data:
   ```

3. Configurar el archivo `application.properties`:

```properties
# Application properties
spring.application.name=paticas

# DataSource properties
spring.datasource.url=jdbc:mysql://localhost:3306/paticasdb
spring.datasource.username=root
spring.datasource.password=mypassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA properties
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Server properties
server.port=8081

# File upload properties
spring.servlet.multipart.enabled=true
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
file.upload-dir=/path/to/upload/dir/
```

4. Ejecutar la aplicación:

```bash
./gradlew bootRun
```

## Documentación API

La  documentación de la API está disponible via Swagger. Tras compilar la aplicación, navegar a  [Swagger](http://localhost:8081/swagger-ui.html):

```json
"url": "http://localhost:8081/swagger-ui.html"
```

## Endoints

### Pets

- GET /api/pets: Get all pets
- GET /api/pets/{id}: Get a pet by ID
- POST /api/pets: Create a new pet
- PUT /api/pets/{id}: Update a pet by ID
- DELETE /api/pets/{id}: Delete a pet by ID
- GET /api/pets/shelter/{shelterId}: Get pets by shelter ID

### Shelters

- GET /api/shelters: Get all shelters
- GET /api/shelters/{id}: Get a shelter by ID
- POST /api/shelters: Create a new shelter
- PUT /api/shelters/{id}: Update a shelter by ID
- DELETE /api/shelters/{id}: Delete a shelter by ID

### Volunteers

- GET /api/volunteers: Get all volunteers
- GET /api/volunteers/{id}: Get a volunteer by ID
- POST /api/volunteers: Create a new volunteer
- PUT /api/volunteers/{id}: Update a volunteer by ID
- DELETE /api/volunteers/{id}: Delete a volunteer by ID
