package com.srinidhi.student_course_management.mapper;

import com.srinidhi.student_course_management.dto.CourseRequestDTO;
import com.srinidhi.student_course_management.dto.CourseResponseDTO;
import com.srinidhi.student_course_management.entity.Course;

public class CourseMapper {
    public static Course toEntity(CourseRequestDTO dto){
        Course course = new Course();
        course.setCourseName(dto.getCourseName());
        course.setTrainer(dto.getTrainer());
        course.setDuration(dto.getDuration());
        return course;
    }
    public static CourseResponseDTO toResponseDTO(Course course){
        CourseResponseDTO dto = new CourseResponseDTO();
        dto.setCourseId(course.getCourseId());
        dto.setCourseName(course.getCourseName());
        dto.setTrainer(course.getTrainer());
        dto.setDuration(course.getDuration());
        return dto;
    }
}
