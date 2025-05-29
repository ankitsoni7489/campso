package com.smartcamp.smartcamp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.smartcamp.smartcamp.model.Task;
import com.smartcamp.smartcamp.repo.*;

@Service
@Transactional 
public class PlannerService {

	
	@Autowired
	private TaskRepo taskRepo;
	
	
	public Task saveTask(Task tasks) {
        return taskRepo.save(tasks);
    }

    // Get All Events
    public List<Task> getAllTask() {
        return taskRepo.findAll();
    }

    public void deleteTaskByName(String taskName) {
        taskRepo.deleteByTaskName(taskName);
    }
    
    
   
	
}
