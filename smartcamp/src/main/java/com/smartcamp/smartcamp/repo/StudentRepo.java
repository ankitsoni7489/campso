package com.smartcamp.smartcamp.repo;



import com.smartcamp.smartcamp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, String> {
    Student findByStudentName(String studentName);

    Student findByUserUsername(String username); // From the User relation
}
