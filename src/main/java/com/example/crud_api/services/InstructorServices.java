package com.example.crud_api.services;

import com.example.crud_api.entities.Instructor;

import java.util.List;

public interface InstructorServices {
    List<Instructor> getAllInstructors();
    Instructor getInstructorById(Long id);
    Instructor saveInstructor(Instructor instructor);
    void deleteInstructor(Long id);

    Instructor updateInstructor(Long id, Instructor updatedInstructor);
}
