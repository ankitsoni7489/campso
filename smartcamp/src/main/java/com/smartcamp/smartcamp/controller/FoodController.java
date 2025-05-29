package com.smartcamp.smartcamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smartcamp.smartcamp.model.Food;
import com.smartcamp.smartcamp.service.FoodService;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;


@Controller
@RequestMapping("/menu")
public class FoodController{
	

	@Autowired
    private FoodService foodService;

    // Shows the page with all events
    @GetMapping("")
    public String showEventsPage(Model model, HttpSession session) {
        List<Food> food = foodService.getAllFood();
        String choice = (String) session.getAttribute("choice");
        model.addAttribute("choice", choice);
        model.addAttribute("food", food);
        return "menu"; 
    }
    
    
    @GetMapping("/food-form")
    public String showForm(Model model, HttpSession session) {
    	String choice = (String) session.getAttribute("choice");
        if("admin".equals(choice))
        {
        	model.addAttribute("food", new Food());
        	return "foodForm";
        }
        return "error"; 
    }
    
    
    @PostMapping("/save-food")
    public String saveEvent(@ModelAttribute Food food,HttpSession session) {
    	String choice = (String) session.getAttribute("choice");
    	 if("admin".equals(choice))
         {
    		 foodService.saveFood(food);
    		 return "redirect:/home"; 
         }
         return "error"; 
        
    }
    
    @PostMapping("/delete-by-name")
    public String deleteByName(@RequestParam String name, HttpSession session) {
    	String choice = (String) session.getAttribute("choice");
    	if("admin".equals(choice))
        {
    		System.out.println("Deleting food with name: " + name);
    		foodService.deleteFoodByName(name);
            return "redirect:/menu"; 
        }
        return "error"; 
        
    }


    
}