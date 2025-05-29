package com.smartcamp.smartcamp.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.smartcamp.smartcamp.repo.UsersRepo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import com.smartcamp.smartcamp.model.Users;
@Service
public class LoginService {

    @Autowired
    private UsersRepo usersRepo;
    
    @Autowired
    private JavaMailSender mailSender;

    public boolean authenticate(String username, String password) {
    	
        Users user = usersRepo.findByUsername(username);
       
        
        if (user != null) {
            // simple plain text check - NOT RECOMMENDED for real apps
            return user.getPassword().equals(password);
        }
        return false;
        
    }
    
    

    public void sendOtpEmail(String to, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Your OTP for password reset");
        message.setText("Your OTP is: " + otp + "\nIt is valid for 2 minutes.");
        mailSender.send(message);
    }
    
    
    public void sendConfirmationEmail(String to) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject("Password Changed Successfully");
            helper.setText(
                "<p>Hello,</p>" +
                "<p>Your password has been successfully changed.</p>" +
                "<p>If you did not request this change, please contact support immediately.</p>" +
                "<br><p>Regards,<br>Your App Team</p>",
                true  // true = isHtml
            );

            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace(); // log error or handle properly in production
        }
    }

}
