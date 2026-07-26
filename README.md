# Student Course Management System

## Project Description

The Student Course Management System is a Spring Boot REST API application designed to manage students, courses, and student enrollments. The project follows a layered architecture and implements industry-standard backend development practices such as DTOs, Mapper Pattern, Validation, Global Exception Handling, and Swagger/OpenAPI documentation.

The application allows users to perform CRUD operations on students and courses while maintaining a Many-to-Many relationship between them.

---

## Features

* Student CRUD Operations
* Course CRUD Operations
* Student Enrollment in Courses
* DTO and Mapper Pattern Implementation
* Request Validation using Jakarta Validation
* Global Exception Handling
* Swagger/OpenAPI Documentation
* Many-to-Many Relationship Mapping using JPA
* Proper HTTP Status Code Handling
* Clean Layered Architecture

---

## Technologies Used

* Java 21 (or your installed Java version)
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Swagger/OpenAPI
* Lombok
* Jakarta Validation API

---

## Project Architecture

```
Client
   |
   v
Controller Layer
   |
   v
Service Layer
   |
   v
Mapper Layer
   |
   v
Repository Layer
   |
   v
MySQL Database
```

The project follows a clean layered architecture to improve maintainability, scalability, and code readability.

---

## Package Structure

```
com.srinidhi.student_course_management

├── config
│      SwaggerConfig.java
│
├── controller
│      StudentController.java
│      CourseController.java
│
├── dto
│      StudentRequestDTO.java
│      StudentResponseDTO.java
│      CourseRequestDTO.java
│      CourseResponseDTO.java
│
├── entity
│      Student.java
│      Course.java
│
├── exception
│      StudentNotFoundException.java
│      CourseNotFoundException.java
│      GlobalExceptionHandler.java
│
├── mapper
│      StudentMapper.java
│      CourseMapper.java
│
├── repository
│      StudentRepository.java
│      CourseRepository.java
│
├── service
│      StudentService.java
│      CourseService.java
│
├── service.impl
│      StudentServiceImpl.java
│      CourseServiceImpl.java
│
└── StudentCourseManagementApplication.java
```

---

## Database Design

### Student Entity

| Field       | Type      |
| ----------- | --------- |
| id          | Long      |
| firstName   | String    |
| lastName    | String    |
| email       | String    |
| department  | String    |
| phoneNumber | String    |
| dateOfBirth | LocalDate |

---

### Course Entity

| Field      | Type   |
| ---------- | ------ |
| courseId   | Long   |
| courseName | String |
| trainer    | String |
| duration   | String |

---

### Relationship

```
Student <------> Course

Many-to-Many Relationship
```

A student can enroll in multiple courses, and a course can have multiple students.

---

## API Endpoints

### Student APIs

| Method | Endpoint                                     | Description              |
| ------ | -------------------------------------------- | ------------------------ |
| POST   | /api/students                                | Add Student              |
| GET    | /api/students                                | Get All Students         |
| GET    | /api/students/{id}                           | Get Student By ID        |
| PUT    | /api/students/{id}                           | Update Student           |
| DELETE | /api/students/{id}                           | Delete Student           |
| POST   | /api/students/{studentId}/courses/{courseId} | Enroll Student in Course |

---

### Course APIs

| Method | Endpoint          | Description      |
| ------ | ----------------- | ---------------- |
| POST   | /api/courses      | Add Course       |
| GET    | /api/courses      | Get All Courses  |
| GET    | /api/courses/{id} | Get Course By ID |
| PUT    | /api/courses/{id} | Update Course    |
| DELETE | /api/courses/{id} | Delete Course    |

---

## Validation

The project uses Jakarta Validation annotations to validate incoming requests.

Examples:

```
@NotBlank
@Email
@Pattern
@Past
@Valid
```

Validation is performed automatically before the request reaches the service layer.

Example validation checks include:

* Empty fields
* Invalid email format
* Invalid phone number format
* Future date of birth values

---

## Exception Handling

The project implements centralized exception handling using:

```
@RestControllerAdvice
@ExceptionHandler
```

Custom Exceptions:

* StudentNotFoundException
* CourseNotFoundException
* MethodArgumentNotValidException

Example Error Response:

```json
{
    "message": "Validation Failed",
    "status": 400,
    "timestamp": "2026-07-27T12:00:00",
    "errors": {
        "email": "must be a well-formed email address"
    }
}
```

---

## DTO and Mapper Pattern

The project uses:

### Request DTOs

* StudentRequestDTO
* CourseRequestDTO

### Response DTOs

* StudentResponseDTO
* CourseResponseDTO

### Mapper Classes

* StudentMapper
* CourseMapper

Benefits:

* Separation of API contracts from entities
* Improved security and maintainability
* Better scalability
* Cleaner service layer implementation

---

## Swagger/OpenAPI Documentation

Swagger has been integrated for interactive API documentation and testing.

Run the application and visit:

```
http://localhost:8080/swagger-ui/index.html
```

Swagger allows you to:

* Explore all APIs
* Execute API requests
* View request and response models
* Test validation and exception handling

---

## How to Run the Project

### Clone the Repository

```
git clone <YOUR_GITHUB_REPOSITORY_URL>
```

### Navigate to the Project

```
cd student-course-management-system
```

### Configure MySQL

Update the following properties in:

```
application.properties
```

```
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
```

### Build the Project

```
mvn clean install
```

### Run the Application

```
mvn spring-boot:run
```

or run the main application class from your IDE.

---

## Future Improvements

Potential enhancements for the project include:

* Spring Security Integration
* JWT Authentication
* Pagination and Sorting
* File Upload APIs
* Unit Testing using JUnit and Mockito
* Spring Boot and React Integration

---

## Screenshots

* Swagger UI
  ![Swagger UI](StudentCMS_Screenshots/Swagger_UI.png)
* Student APIs
* Course APIs
* Validation Error Responses
* Exception Handling Responses


## Author

**Namrutha Srinidhi T**

Backend Developer | Java | Spring Boot | REST APIs | MySQL

This project was developed as part of learning and implementing Spring Boot backend development concepts and industry-standard design practices.
