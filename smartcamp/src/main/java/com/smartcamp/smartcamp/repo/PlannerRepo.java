package com.smartcamp.smartcamp.repo;



import com.smartcamp.smartcamp.model.Planner;
import com.smartcamp.smartcamp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlannerRepo extends JpaRepository<Planner, Long> {
    List<Planner> findByStudent(Student student);
}
