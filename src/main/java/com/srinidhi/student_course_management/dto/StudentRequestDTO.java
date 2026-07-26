package com.srinidhi.student_course_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String department;
    @Pattern(
            regexp = "^\\+?[0-9]{10,15}$",
            message = "Invalid phone number format"
    )
    private String phoneNumber;
    @Past
    private LocalDate dateOfBirth;


}
