package com.srinidhi.student_course_management.controller;

import com.srinidhi.student_course_management.dto.CourseRequestDTO;
import com.srinidhi.student_course_management.dto.CourseResponseDTO;
import com.srinidhi.student_course_management.service.CourseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Course APIs",
        description = "Operations related to course management."
)
@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    // ADD course
    @PostMapping
    public ResponseEntity<CourseResponseDTO> addCourse(@Valid @RequestBody CourseRequestDTO dto){
        CourseResponseDTO savedCourse = courseService.addCourse(dto);
        return new ResponseEntity<>(
                savedCourse,
                HttpStatus.CREATED
        );
    }

    // Retrieve all courses
    @GetMapping
    public ResponseEntity<List<CourseResponseDTO>> getAllCourses(){
        List<CourseResponseDTO> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    // Retrieve course by id
    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> getCourseById(@PathVariable Long id){
        CourseResponseDTO course = courseService.getCourseById(id);
        return ResponseEntity.ok(course);
    }

    // Update course by id
    @PutMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> updateCourse(
            @PathVariable Long id,
            @Valid @RequestBody CourseRequestDTO dto){
        CourseResponseDTO updatedCourse = courseService.updateCourse(id, dto);
        return ResponseEntity.ok(updatedCourse);
    }

    // Delete course by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course deleted Successfully");
    }
}
