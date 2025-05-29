package com.smartcamp.smartcamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;





import com.smartcamp.smartcamp.model.Task;

import com.smartcamp.smartcamp.service.PlannerService;

import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/task")
public class PlannerController {

	
	@Autowired
    private PlannerService plannerService;
	
	@GetMapping("")
    public String showEventsPage(Model model,HttpSession session) {
        List<Task> tasks = plannerService.getAllTask();
        model.addAttribute("tasks", tasks);
        
       
        
        return "planner"; 
        
         
    }
	
	
	@GetMapping("/task-form")
    public String showForm(Model model) {
    	
        
        	model.addAttribute("tasks", new Task());
        	return "taskform";
        
       
    }
    
    
    @PostMapping("/save-task")
    public String saveTask(@ModelAttribute Task tasks) {
    	
    	 
    		 plannerService.saveTask(tasks);
    		 return "redirect:/task"; 
        
        
    }
    
    
    @PostMapping("/delete-by-name/{name}")
    public String deleteByName(@PathVariable("name") String name) {
    	
    		plannerService.deleteTaskByName(name);
            return "redirect:/task"; 
        
        
    }
    
    
    
    
   
  
    
}
