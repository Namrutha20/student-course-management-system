package com.srinidhi.student_course_management.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponseDTO {
    private Long courseId;
    private String courseName;
    private String trainer;
    private String duration;
}
