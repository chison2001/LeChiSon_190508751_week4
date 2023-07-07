package com.example.crud_api.services;

import com.example.crud_api.entities.Course;

import java.util.List;

public interface CourseServices {
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);
    Course updateCourse(Long id, Course updatedCourse);
}
