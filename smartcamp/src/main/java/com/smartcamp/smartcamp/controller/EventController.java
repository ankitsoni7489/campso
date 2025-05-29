package com.smartcamp.smartcamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.smartcamp.smartcamp.model.Events;
import com.smartcamp.smartcamp.service.EventService;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

import java.io.IOException;
import java.util.Base64;

@Controller
@RequestMapping("/event")
public class EventController{
	

	@Autowired
    private EventService eventService;

    // Shows the page with all events
    @GetMapping("")
    public String showEventsPage(Model model, HttpSession session) {
        List<Events> events = eventService.getAllEvents();
        String choice = (String) session.getAttribute("choice");
        events.forEach(event -> {
            if (event.getImageData() != null) {
                String base64Image = Base64.getEncoder().encodeToString(event.getImageData());
                event.setBase64Image(base64Image);  // add a transient field in Event class to hold this
            }
        });
        model.addAttribute("events", events);
        model.addAttribute("choice", choice);
        return "event"; 
    }
    
    
    @GetMapping("/event-form")
    public String showForm(Model model, HttpSession session) {
    	String choice = (String) session.getAttribute("choice");
        if("admin".equals(choice))
        {
        	model.addAttribute("event", new Events());
        	return "eventform";
        }
        return "error"; 
    }
    
    
    @PostMapping("/save-event")
    public String saveEvent(@ModelAttribute Events events,
                            @RequestParam("imageFile") MultipartFile file,
                            HttpSession session) throws IOException {
        String choice = (String) session.getAttribute("choice");
        if ("admin".equals(choice)) {
            if (!file.isEmpty()) {
                byte[] imageBytes = file.getBytes();
                events.setImageData(imageBytes);
            }
            eventService.saveEvent(events);
            return "redirect:/home";
        }
        return "error";
    }

    
    @GetMapping("/delete-by-name")
    public String deleteByName(@RequestParam String name, HttpSession session) {
    	String choice = (String) session.getAttribute("choice");
    	if("admin".equals(choice))
        {
    		eventService.deleteEventByName(name);
            return "redirect:/event"; 
        }
        return "error"; 
        
    }

    
}