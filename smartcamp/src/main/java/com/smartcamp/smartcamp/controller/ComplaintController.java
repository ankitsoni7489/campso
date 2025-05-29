package com.smartcamp.smartcamp.controller;



import com.smartcamp.smartcamp.model.Complaint;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import com.smartcamp.smartcamp.service.ComplaintService;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;
    
    
   

    // Show form to register a complaint
    @GetMapping("/new")
    public String showComplaintForm(Model model, HttpSession session) {
    	String choice = (String) session.getAttribute("choice");
        model.addAttribute("complaint", new Complaint());
        model.addAttribute("choice", choice);
        return "admin-complaints";
    }

    // Submit a complaint
    @PostMapping("/submit")
    public String submitComplaint(@ModelAttribute Complaint complaint) {
        complaintService.saveComplaint(complaint);
        
        return "redirect:/login" ;
    }

   
    @PostMapping("/track")
    public String trackComplaint(@RequestParam("trackingId") String trackingId, Model model, RedirectAttributes redirectAttributes, HttpSession session) {
        Optional<Complaint> complaintOpt = complaintService.getComplaintByTrackingId(trackingId);
        String choice = (String) session.getAttribute("choice");
    	model.addAttribute("choice", choice);
        if (complaintOpt.isPresent()) {
            model.addAttribute("complaint", complaintOpt.get());
            model.addAttribute("choice", choice);
            return "track"; // Show complaint details
        } else {
        	redirectAttributes.addFlashAttribute("error", "Complaint with tracking ID not found.");
            return "redirect:/complaints/admin";
        }
    }

   

    // Admin view all complaints
    @GetMapping("/admin")
    public String viewAllComplaints(Model model, HttpSession session) {
        List<Complaint> complaints = complaintService.getAllComplaints();
        String choice = (String) session.getAttribute("choice");
        model.addAttribute("choice", choice);
        model.addAttribute("complaints", complaints);
        model.addAttribute("complaint", new Complaint()); // ✅ Add this line
        return "admin-complaints";
    }


    // Admin accept/reject complaint
    @PostMapping("/admin/updateStatus/{id}")
    public String updateStatus(@PathVariable Integer id, @RequestParam String status) {
        complaintService.updateComplaintStatus(id, status);
        return "redirect:/complaints/admin";
    }
    
    
    @GetMapping("/delete-by-name")
    public String deleteByName(@RequestParam("track") String trackingId, HttpSession session, Model model) {
    	String choice = (String) session.getAttribute("choice");
    	model.addAttribute("choice", choice);
    	if("admin".equals(choice))
        {
    		complaintService.deleteComplaintByTrack(trackingId);
            return "redirect:/complaints/admin"; 
        }
        return "error"; 
        
    }


    
}
