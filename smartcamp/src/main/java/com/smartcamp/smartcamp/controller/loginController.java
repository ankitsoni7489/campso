package com.smartcamp.smartcamp.controller;




import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.smartcamp.smartcamp.repo.UsersRepo;
import com.smartcamp.smartcamp.service.LoginService;

import jakarta.servlet.http.HttpSession;


import com.smartcamp.smartcamp.model.*;

@Controller

public class loginController {

    @Autowired
    private LoginService userService;
    
    @Autowired
    private UsersRepo usersRepo;
    
    
    private Map<String, OtpStore> otpMap = new HashMap<>();
    
    @GetMapping("/")
    public String showLoginPage() {
        return "login"; 
    }

    @PostMapping("/login")
   
    public String login(@RequestParam String username, @RequestParam String password,@RequestParam String choice, HttpSession session) {
        boolean isAuthenticated = userService.authenticate(username, password);
       
        Users user = usersRepo.findByUsername(username);
        
        String role = user.getRole();
       
        if (isAuthenticated && role.equals(choice)) {
        	session.setAttribute("username", username);
        	session.setAttribute("choice", choice);
            return "redirect:/home";
        } else if (isAuthenticated && role.equals(choice))
        {
        	session.setAttribute("username", username);
        	session.setAttribute("choice", choice);
            return "redirect:/home";
        }
        else {
            return "login" ;
        }
    }
   
    @GetMapping("/home")
	public String home(HttpSession session, Model model) {
	    String username = (String) session.getAttribute("username");
	    model.addAttribute("username", username);
	    return "home";
	}
    
    @GetMapping("/dashboard")
	public String event(HttpSession session, Model model) {
	    String username = (String) session.getAttribute("username");
	    model.addAttribute("username", username);
	    return "dashboard";
	}
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalidate the session
        return "redirect:/login"; // Redirect to login page
    }

    
    
    @GetMapping("/forgot")
    public String showForgotForm() {
        return "forgot";
    }
    
    @PostMapping("/send-otp")
    public String sendOtp(@RequestParam String email, Model model) {
        Optional<Users> userOpt = usersRepo.findByEmail(email);
        if (userOpt.isEmpty()) {
            model.addAttribute("error", "Email not found");
            return "forgot";
        }

        String otp = String.valueOf(new Random().nextInt(900000) + 100000); // 6-digit OTP
        long expiryTime = System.currentTimeMillis() + 2 * 60 * 1000; // 2 minutes

        otpMap.put(email, new OtpStore(otp, expiryTime));
        userService.sendOtpEmail(email, otp);

        model.addAttribute("email", email);
        return "verify-otp";
    }
    
    
    
    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestParam String email, @RequestParam String otp, Model model) {
        OtpStore stored = otpMap.get(email);
        if (stored == null || !stored.getOtp().equals(otp)) {
            model.addAttribute("error", "Invalid OTP");
            model.addAttribute("email", email);
            return "verify-otp";
        }

        if (System.currentTimeMillis() > stored.getExpiryTime()) {
            model.addAttribute("error", "OTP expired");
            model.addAttribute("email", email);
            return "verify-otp";
        }

        model.addAttribute("email", email);
        return "reset"; // reset.html
    }
    
    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String email, @RequestParam String password, Model model) {
        Optional<Users> userOpt = usersRepo.findByEmail(email);
        if (userOpt.isEmpty()) {
            model.addAttribute("error", "Email not found");
            return "reset";
        }

        Users user = userOpt.get();
        user.setPassword(password); // In production, always hash passwords
        usersRepo.save(user);
        userService.sendConfirmationEmail(email);
        model.addAttribute("message", "Password updated successfully");
        return "login";
    }
}
