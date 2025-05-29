package com.smartcamp.smartcamp.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.smartcamp.smartcamp.model.Faculty;
import com.smartcamp.smartcamp.service.FacultyService;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;


@Controller
@RequestMapping("/faculty")
public class FacultyController{
	

	@Autowired
    private FacultyService facultyService;

    // Shows the page with all events
    @GetMapping("")
    public String showEventsPage(Model model, HttpSession session) {
        List<Faculty> faculty = facultyService.getAllFaculty();
        String choice = (String) session.getAttribute("choice");
        faculty.forEach(facultys -> {
            if (facultys.getImageData() != null) {
                String base64Image = Base64.getEncoder().encodeToString(facultys.getImageData());
                facultys.setBase64Image(base64Image);  // add a transient field in Event class to hold this
            }
        });

        model.addAttribute("faculty", faculty);
        model.addAttribute("choice", choice);
        return "faculty"; 
    }
    
    
    @GetMapping("/faculty-form")
    public String showForm(Model model, HttpSession session) {
    	String choice = (String) session.getAttribute("choice");
        if("admin".equals(choice))
        {
        	model.addAttribute("faculty", new Faculty());
        	return "facultyForm";
        }
        return "error"; 
    }
    
    
    @PostMapping("/save-faculty")
    public String saveEvent(@ModelAttribute Faculty faculty,HttpSession session, @RequestParam("imageFile") MultipartFile file)
            													throws IOException {
    	String choice = (String) session.getAttribute("choice");
    	 if("admin".equals(choice))
         {
    		 if (!file.isEmpty()) {
                 byte[] imageBytes = file.getBytes();
                 faculty.setImageData(imageBytes);
             }
    		 facultyService.saveFaculty(faculty);
    		 return "redirect:/home"; 
         }
         return "error"; 
        
    }
    
    @GetMapping("/delete-by-name")
    public String deleteByName(@RequestParam String name, HttpSession session) {
    	String choice = (String) session.getAttribute("choice");
    	if("admin".equals(choice))
        {
    		facultyService.deleteFacultyByName(name);
            return "redirect:/faculty"; 
        }
        return "error"; 
        
    }

    
}