package com.srinidhi.student_course_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    @NotBlank
    private String courseName;
    @NotBlank
    private String trainer;
    @NotBlank
    private String duration;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();
}
