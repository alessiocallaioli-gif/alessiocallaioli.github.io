# User Management API

A RESTful API for managing users built with Spring Boot and MySQL.

## Features
- Create, read, update, and delete users (CRUD)
- Validation for email and mandatory fields
- Modular architecture with service, repository, and controller layers

## Technology Stack
- Java 17+
- Spring Boot 3
- MySQL
- Maven

## Run
1. Create a MySQL database `user_db`.
2. Update `application.properties` with your credentials.
3. Run the application:
```bash
mvn spring-boot:run