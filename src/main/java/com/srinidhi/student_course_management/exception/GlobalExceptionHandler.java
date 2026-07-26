package com.srinidhi.student_course_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleStudentNotFoundExceptions(StudentNotFoundException ex){
        return buildErrorResponse(
                ex.getMessage(),
                HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleCourseNotFoundExceptions(CourseNotFoundException ex){
        return buildErrorResponse(
                ex.getMessage(),
                HttpStatus.NOT_FOUND);
    }

    // Helper method (NOT an exception handler)
    private ResponseEntity<Map<String, Object>>
    buildErrorResponse(String message, HttpStatus status) {

        Map<String, Object> response = new HashMap<>();

        response.put("message", message);
        response.put("status", status.value());
        response.put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(status)
                .body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        for(FieldError error : ex.getBindingResult().getFieldErrors()){
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Validation Failed");
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("timestamp", LocalDateTime.now());
        response.put("errors", errors);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }
}
