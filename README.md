# Paticas API

Paticas API is a RESTful web service for managing pets and shelters. It supports CRUD operations for pets, shelters, and volunteers. The API also provides file upload functionality for managing pet images.

## Table of contents

- [Paticas API](#paticas-api)
  - [Table of contents](#table-of-contents)
  - [Features](#features)
  - [Technologies Used](#technologies-used)
  - [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Setup](#setup)
  - [API Documentation](#api-documentation)
  - [Endoints](#endoints)
    - [Pets](#pets)
    - [Shelters](#shelters)
    - [Volunteers](#volunteers)
  - [Contributing](#contributing)

## Features

- CRUD operations for Pets
- CRUD operations for Shelters
- CRUD operations for Volunteers
- File upload for pet images
- Pagination and filtering for pets
- Swagger documentation

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Gradle
- Swagger
- Docker

## Getting Started

### Prerequisites

- Java 11 or higher
- MySQL
- Docker (optional)
- Gradle

### Setup

1. Clone the repository:

```bash
git clone https://github.com/yourusername/paticas-api.git
cd paticas-api
```

2. Set up the MySQL database:

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

3. Build and run the services:

```bash
docker-compose up --build
```

4. Configure the `application.properties` file:

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

4. Build and run the application:

```bash
./gradlew bootRun
```

## API Documentation

The API documentation is available via Swagger. After starting the application, navigate to [Swagger](http://localhost:8081/swagger-ui.html):

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

## Contributing

Contributions are welcome! Please open an issue or submit a pull request. I tried to use Git flow, PRs and  [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/)
