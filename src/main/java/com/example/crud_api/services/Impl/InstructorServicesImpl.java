package com.example.crud_api.services.Impl;

import com.example.crud_api.entities.Instructor;
import com.example.crud_api.repositories.InstructorRepository;
import com.example.crud_api.services.InstructorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServicesImpl implements InstructorServices {
    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Instructor not found"));
    }

    @Override
    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }
    @Override
    public void deleteInstructor(Long id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public Instructor updateInstructor(Long id, Instructor updatedInstructor) {
        Instructor instructor = getInstructorById(id);
        instructor.setName(updatedInstructor.getName());
        return instructorRepository.save(instructor);
    }
}
