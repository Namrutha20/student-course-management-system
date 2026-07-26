package com.srinidhi.student_course_management.controller;

import com.srinidhi.student_course_management.dto.StudentRequestDTO;
import com.srinidhi.student_course_management.dto.StudentResponseDTO;
import com.srinidhi.student_course_management.service.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Student APIs",
        description = "Operations related to student management."
)
@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // Add new student with status code 201 Created
    @PostMapping
    public ResponseEntity<StudentResponseDTO> addStudent(@Valid @RequestBody StudentRequestDTO dto){
        return new ResponseEntity<>(
                studentService.addStudent(dto),
                HttpStatus.CREATED
        );
    }

    // Get student with status code 200 OK
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable Long id){
        return new ResponseEntity<>(
                studentService.getStudentById(id),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent(@PathVariable Long id, @Valid @RequestBody StudentRequestDTO dto){
        return new ResponseEntity<>(studentService.updateStudent(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }

    @PostMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<StudentResponseDTO> enrollStudentInCourse(@PathVariable Long studentId, @PathVariable Long courseId){
        return ResponseEntity.ok(
                studentService.enrollStudentInCourse(studentId, courseId)
        );
    }
}
