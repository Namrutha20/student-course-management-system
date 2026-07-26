package com.srinidhi.student_course_management.service;

import com.srinidhi.student_course_management.dto.StudentRequestDTO;
import com.srinidhi.student_course_management.dto.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    StudentResponseDTO addStudent(StudentRequestDTO dto);
    public StudentResponseDTO getStudentById(Long id);
    public List<StudentResponseDTO> getAllStudents();
    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto);
    public void deleteStudent(Long id);

    StudentResponseDTO enrollStudentInCourse(Long studentId, Long courseId);
}

