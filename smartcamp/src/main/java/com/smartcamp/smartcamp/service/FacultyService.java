package com.smartcamp.smartcamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import com.smartcamp.smartcamp.repo.FacultyRepo;
import com.smartcamp.smartcamp.model.Faculty;
@Service
@Transactional 
public class FacultyService {

    @Autowired
    private FacultyRepo facultyRepo;

    // Add or Update Event
    public Faculty saveFaculty(Faculty faculty) {
        return facultyRepo.save(faculty);
    }

    // Get All Events
    public List<Faculty> getAllFaculty() {
        return facultyRepo.findAll();
    }

    // Get Single Event by ID
    public Optional<Faculty> getFacultyById(Long id) {
        return facultyRepo.findById(id);
    }

    // Delete Event by ID
    public void deleteFaculty(Long id) {
    	facultyRepo.deleteById(id);
    }
    
    public void deleteFacultyByName(String eventName) {
    	facultyRepo.deleteByFacultyName(eventName);
    }

	

}
