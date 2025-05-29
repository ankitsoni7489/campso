package com.smartcamp.smartcamp.controller;

import com.smartcamp.smartcamp.model.LostFound;
import com.smartcamp.smartcamp.service.LostAndFoundService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/lost-found")
public class LostAndFoundController {

    @Autowired
    private LostAndFoundService service;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("item", new LostFound());
        return "lostfound";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute LostFound item) {
        item.setDate(LocalDate.now()); // Auto-set current date
        service.saveItem(item);
        return "redirect:/lost-found/list";
    }

    @GetMapping("/list")
    public String viewItems(Model model) {
        model.addAttribute("items", service.getAllItems());
        return "found";
    }
}
