package com.smartcamp.smartcamp.controller;

import com.smartcamp.smartcamp.model.Link;
import com.smartcamp.smartcamp.service.LinkService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/links")
public class LinkController {

    @Autowired
    private LinkService scholarshipService;

    // Show all scholarships page
    @GetMapping("")
    public String viewScholarships(Model model, HttpSession session) {
        List<Link> scholarships = scholarshipService.getAllScholarships();
        String choice = (String) session.getAttribute("choice");
        model.addAttribute("scholarships", scholarships);
        model.addAttribute("choice", choice);
        return "link";  // Thymeleaf template: scholarships.html
    }

    // Show form to add new scholarship
    @GetMapping("/admin/add")
    public String showAddScholarshipForm(Model model) {
        model.addAttribute("link", new Link());
        return "link-form";  // Thymeleaf template: add-scholarship.html
    }

    // Handle form submission for adding scholarship
    @PostMapping("/admin/add")
    public String addScholarshipSubmit(@ModelAttribute Link link) {
        scholarshipService.addScholarship(link);
        return "redirect:/links";  // Redirect back to list
    }

    // Delete scholarship by title (via POST)
    @PostMapping("/admin/delete/{title}")
    public String deleteScholarship(@PathVariable String title) {
        scholarshipService.deleteScholarshipByTitle(title);
        return "redirect:/links";  // Redirect back to list
    }
}
