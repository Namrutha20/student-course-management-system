package com.srinidhi.student_course_management.service.impl;

import com.srinidhi.student_course_management.dto.StudentRequestDTO;
import com.srinidhi.student_course_management.dto.StudentResponseDTO;
import com.srinidhi.student_course_management.entity.Course;
import com.srinidhi.student_course_management.entity.Student;
import com.srinidhi.student_course_management.exception.CourseNotFoundException;
import com.srinidhi.student_course_management.exception.StudentNotFoundException;
import com.srinidhi.student_course_management.mapper.StudentMapper;
import com.srinidhi.student_course_management.repository.CourseRepository;
import com.srinidhi.student_course_management.repository.StudentRepository;
import com.srinidhi.student_course_management.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository){
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }


    @Override
    public StudentResponseDTO addStudent(StudentRequestDTO dto) {
        Student student = StudentMapper.toEntity(dto);
        Student savedStudent  = studentRepository.save(student);
        return StudentMapper.toResponseDTO(savedStudent);
    }

    @Override
    public StudentResponseDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
        return StudentMapper.toResponseDTO(student);
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        List<Student> list = studentRepository.findAll();
        List<StudentResponseDTO> listOfStudents = new ArrayList<>();
        for(Student st : list){
            listOfStudents.add(StudentMapper.toResponseDTO(st));
        }
        return listOfStudents;
    }

    @Override
    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto) {
        Student st = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
        st.setFirstName(dto.getFirstName());
        st.setLastName(dto.getLastName());
        st.setDepartment(dto.getDepartment());
        st.setEmail(dto.getEmail());
        st.setPhoneNumber(dto.getPhoneNumber());
        st.setDateOfBirth(dto.getDateOfBirth());
        Student savedStudent = studentRepository.save(st);
        return StudentMapper.toResponseDTO(savedStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        Student st = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
        studentRepository.delete(st);
    }

    @Override
    public StudentResponseDTO enrollStudentInCourse(Long studentId, Long courseId){
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + studentId));
        Course course = courseRepository.findById(courseId)
                        .orElseThrow(() -> new CourseNotFoundException("Course not found with id: " + courseId));
        student.getCourses().add(course);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.toResponseDTO(savedStudent);
    }
}
