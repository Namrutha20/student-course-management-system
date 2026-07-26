package com.srinidhi.student_course_management.service;

import com.srinidhi.student_course_management.dto.CourseRequestDTO;
import com.srinidhi.student_course_management.dto.CourseResponseDTO;

import java.util.List;

public interface CourseService {
    CourseResponseDTO addCourse(CourseRequestDTO dto);
    CourseResponseDTO getCourseById(Long courseId);
    List<CourseResponseDTO> getAllCourses();
    CourseResponseDTO updateCourse(Long courseId, CourseRequestDTO dto);
    void deleteCourse(Long courseId);
}
