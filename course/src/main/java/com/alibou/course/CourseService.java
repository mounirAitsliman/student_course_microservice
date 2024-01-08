package com.mounir.course;

import com.mounir.course.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final courseRepository repository;
    private final StudentClient client;

    public void savecourse(course course) {
        repository.save(course);
    }

    public List<course> findAllcourses() {
        return repository.findAll();
    }

    public FullcourseResponse findcoursesWithStudents(Integer courseId) {
        var course = repository.findById(courseId)
                .orElse(
                        course.builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()
                );
        var students = client.findAllStudentsBycourse(courseId);
        return FullcourseResponse.builder()
                .name(course.getName())
                .email(course.getEmail())
                .students(students)
                .build();
    }
}
