# Gym Membership System

A complete Spring Boot project to manage gym members, membership plans, and subscriptions.

## Features
- Add, view, edit, and delete members
- Add, view, edit, and delete plans
- Add and delete subscriptions
- Auto-calculate subscription end date from selected plan
- Dashboard with total counts
- Thymeleaf UI
- MySQL integration
- Sample data loader included

## Tech Stack
- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Thymeleaf
- MySQL
- Maven

## Database
Update `src/main/resources/application.properties`:

```properties
spring.datasource.username=root
spring.datasource.password=yourpassword
```

## Run
```bash
mvn spring-boot:run
```

Open:
- http://localhost:8080/

## Notes
- Database name used: `gymdb`
- `createDatabaseIfNotExist=true` is already added in datasource URL
