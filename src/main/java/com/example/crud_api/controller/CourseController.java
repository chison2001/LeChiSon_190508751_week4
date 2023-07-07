package com.example.crud_api.controller;

import com.example.crud_api.entities.Course;
import com.example.crud_api.entities.Instructor;
import com.example.crud_api.services.CourseServices;
import com.example.crud_api.services.InstructorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseServices courseService;
    private final InstructorServices instructorService;

    public CourseController(CourseServices courseService, InstructorServices instructorService) {
        this.courseService = courseService;
        this.instructorService = instructorService;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course, @RequestParam Long instructorId) {
        Instructor instructor = instructorService.getInstructorById(instructorId);
        course.setInstructor(instructor);
        return courseService.saveCourse(course);
    }

    @PostMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse, @RequestParam Long instructorId) {
        Instructor instructor = instructorService.getInstructorById(instructorId);
        updatedCourse.setInstructor(instructor);
        return courseService.updateCourse(id, updatedCourse);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}
