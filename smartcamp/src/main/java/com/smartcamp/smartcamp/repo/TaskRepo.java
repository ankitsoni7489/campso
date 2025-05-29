package com.smartcamp.smartcamp.repo;



import com.smartcamp.smartcamp.model.Task;
import com.smartcamp.smartcamp.model.Planner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, String> {
    List<Task> findByPlanner(Planner planner);

    List<Task> findBySubject(String subject);

	void deleteByTaskName(String eventName);
}

