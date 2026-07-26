package com.srinidhi.student_course_management.service.impl;

import com.srinidhi.student_course_management.dto.CourseRequestDTO;
import com.srinidhi.student_course_management.dto.CourseResponseDTO;
import com.srinidhi.student_course_management.entity.Course;
import com.srinidhi.student_course_management.exception.CourseNotFoundException;
import com.srinidhi.student_course_management.mapper.CourseMapper;
import com.srinidhi.student_course_management.repository.CourseRepository;
import com.srinidhi.student_course_management.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseResponseDTO addCourse(CourseRequestDTO dto){
        Course course = CourseMapper.toEntity(dto);
        Course savedCourse = courseRepository.save(course);
        return CourseMapper.toResponseDTO(savedCourse);
    }

    @Override
    public CourseResponseDTO getCourseById(Long courseId){
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with id: " + courseId));
        return CourseMapper.toResponseDTO(course);
    }

    @Override
    public List<CourseResponseDTO> getAllCourses(){
        List<Course> courses = courseRepository.findAll();
        List<CourseResponseDTO> listOfCourses = new ArrayList<>();
        for(Course course : courses){
            listOfCourses.add(CourseMapper.toResponseDTO(course));
        }
        return listOfCourses;
    }

    @Override
    public CourseResponseDTO updateCourse(Long courseId, CourseRequestDTO dto){
        Course existingCourse = courseRepository.findById(courseId)
                .orElseThrow(() ->
                        new CourseNotFoundException("Course not found with id: " + courseId));
        existingCourse.setCourseName(dto.getCourseName());
        existingCourse.setTrainer(dto.getTrainer());
        existingCourse.setDuration(dto.getDuration());
        Course savedCourse =  courseRepository.save(existingCourse);
        return CourseMapper.toResponseDTO(savedCourse);
    }

    @Override
    public void deleteCourse(Long courseId){
        Course course = courseRepository.findById(courseId).orElseThrow(() ->
                new CourseNotFoundException("Course not found with id: " + courseId));
        courseRepository.delete(course);
    }
}
