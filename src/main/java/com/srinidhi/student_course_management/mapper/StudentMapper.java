package com.srinidhi.student_course_management.mapper;

import com.srinidhi.student_course_management.dto.StudentRequestDTO;
import com.srinidhi.student_course_management.dto.StudentResponseDTO;
import com.srinidhi.student_course_management.entity.Course;
import com.srinidhi.student_course_management.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {
    public static Student toEntity(StudentRequestDTO dto){
        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setDepartment(dto.getDepartment());
        student.setPhoneNumber(dto.getPhoneNumber());
        student.setDateOfBirth(dto.getDateOfBirth());
        return student;
    }
    public static StudentResponseDTO toResponseDTO(Student student){
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setId(student.getId());
        studentResponseDTO.setFirstName(student.getFirstName());
        studentResponseDTO.setLastName(student.getLastName());
        studentResponseDTO.setEmail(student.getEmail());
        studentResponseDTO.setDepartment(student.getDepartment());
        studentResponseDTO.setPhoneNumber(student.getPhoneNumber());
        studentResponseDTO.setDateOfBirth(student.getDateOfBirth());
        List<String> courseNames = new ArrayList<>();
        for(Course course : student.getCourses()){
            String name = course.getCourseName();
            courseNames.add(name);
        }
        studentResponseDTO.setCourseNames(courseNames);
        return studentResponseDTO;
    }
}
