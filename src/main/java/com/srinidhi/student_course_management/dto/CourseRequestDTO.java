package com.srinidhi.student_course_management.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequestDTO {
    @NotBlank
    private String courseName;
    @NotBlank
    private String trainer;
    @NotBlank
    private String duration;
}
