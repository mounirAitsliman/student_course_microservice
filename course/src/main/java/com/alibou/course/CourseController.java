package com.mounir.course;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final courseService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(
            @RequestBody course course
    ) {
        service.savecourse(course);
    }

    @GetMapping
    public ResponseEntity<List<course>> findAllcourses() {
        return ResponseEntity.ok(service.findAllcourses());
    }

    @GetMapping("/with-students/{course-id}")
    public ResponseEntity<FullcourseResponse> findAllcourses(
            @PathVariable("course-id") Integer courseId
    ) {
        return ResponseEntity.ok(service.findcoursesWithStudents(courseId));
    }
}
