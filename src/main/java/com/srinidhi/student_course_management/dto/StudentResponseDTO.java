package com.srinidhi.student_course_management.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String department;

    private String phoneNumber;

    private LocalDate dateOfBirth;

    private List<String> courseNames;
}
