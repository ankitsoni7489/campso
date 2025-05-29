package com.smartcamp.smartcamp.repo;


import com.smartcamp.smartcamp.model.Faculty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty, Long> {

	void deleteByFacultyName(String facultyName);
    // Additional query methods can be defined here
}
