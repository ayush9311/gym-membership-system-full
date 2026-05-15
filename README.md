# Gym Membership System

A full-stack Gym Membership Management System developed using Spring Boot, Thymeleaf, MySQL, and Bootstrap. This application helps gym administrators efficiently manage members, membership plans, subscriptions, and dashboard analytics through a user-friendly web interface.

---

## Features

- Member Registration and Management
- Membership Plan Management
- Subscription Tracking System
- Automatic Subscription Expiry Detection
- Dashboard Analytics and Statistics
- REST API Integration
- Responsive User Interface
- CRUD Operations
- Active and Expired Status Monitoring

---

## Technology Stack

### Backend
- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate

### Frontend
- Thymeleaf
- HTML5
- CSS3
- Bootstrap
- JavaScript
- Chart.js

### Database
- MySQL

### Tools & Platforms
- Eclipse IDE
- Maven
- Git & GitHub

---

## Project Modules

### Member Module
- Add new gym members
- Update member details
- Delete members
- View member records

### Membership Plan Module
- Create membership plans
- Manage pricing and duration
- Update plan details

### Subscription Module
- Assign plans to members
- Track subscription dates
- Detect expired memberships automatically

### Dashboard Module
- Total Members Overview
- Active Subscription Statistics
- Revenue Insights
- Dynamic Charts and Analytics

---

## REST API Integration

The project uses REST APIs for handling dashboard statistics and dynamic data updates.

### Example Endpoint

```http
/api/dashboard/stats
```

---

## Database Configuration

The project uses MySQL database with Spring Data JPA and Hibernate ORM for efficient database operations.

Update the following configuration in:

```properties
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gymdb
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## Project Structure

```text
src/
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── dto
 ├── config
 ├── static
 └── templates
```

---

## How to Run the Project

### 1. Clone Repository

```bash
git clone https://github.com/ayush9311/gym-membership-system-full.git
```

### 2. Open Project
- Open Eclipse or IntelliJ IDEA
- Import as Maven Project

### 3. Configure Database
- Create MySQL database:
```sql
CREATE DATABASE gymdb;
```

- Update database credentials in:
```properties
application.properties
```

### 4. Run Application

```bash
mvn spring-boot:run
```

### 5. Open Browser

```text
http://localhost:8081
```

---

## Future Improvements

- Role-Based Authentication
- Payment Gateway Integration
- Email Notifications
- Mobile Responsive Dashboard
- Cloud Deployment
- Attendance Tracking System
- AI-Based Fitness Recommendation
- Admin Analytics Dashboard

---

## Learning Outcomes

Through this project, the following concepts were implemented and learned:

- Spring Boot Application Development
- MVC Architecture
- REST API Development
- Database Connectivity with MySQL
- CRUD Operations
- Dashboard Visualization
- Git and GitHub Version Control
- Frontend and Backend Integration

---

## Screenshots

Add screenshots of:
- Login Page
- Dashboard
- Member Management
- Subscription Module
- Analytics Charts

---

## Author

### Ayush Kumar Singh

- GitHub: https://github.com/ayush9311

---

## License

This project is developed for educational and learning purposes.
