package com.smartcamp.smartcamp.service;



import com.smartcamp.smartcamp.model.Complaint;
import com.smartcamp.smartcamp.repo.*;

import jakarta.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.mail.internet.MimeMessage;


import java.util.List;
import java.util.Optional;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepo complaintRepository;

    @Autowired
    private JavaMailSender mailSender;

    public Complaint saveComplaint(Complaint complaint) {
        Complaint savedComplaint = complaintRepository.save(complaint);

        // Send tracking ID email after saving
        sendTrackEmail(savedComplaint.getEmail(), savedComplaint.getStudentName(), savedComplaint.getTrackingId());

        return savedComplaint;
    }

    public Optional<Complaint> getComplaintByTrackingId(String trackingId) {
        return complaintRepository.findByTrackingId(trackingId);
    }

    
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    public List<Complaint> getComplaintsByStudentId(String studentId) {
        return complaintRepository.findByStudentId(studentId);
    }

    public Optional<Complaint> getComplaintById(Integer id) {
        return complaintRepository.findById(id);
    }

    public void updateComplaintStatus(Integer complaintId, String newStatus) {
        Optional<Complaint> optional = complaintRepository.findById(complaintId);
        if (optional.isPresent()) {
            Complaint complaint = optional.get();
            complaint.setStatus(newStatus);
            complaintRepository.save(complaint);
            System.err.println(complaint.getEmail());

            // Send email notification
            sendStatusEmail(complaint.getEmail(), complaint.getStudentName(), newStatus);
        }
    }

    private void sendStatusEmail(String toEmail, String studentName, String status) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
            helper.setTo(toEmail);
            helper.setSubject("Your Complaint Status");
            helper.setText("Dear " + studentName + ",\n\nYour complaint has been " + status + ".\n\nRegards,\nSmartCampus Team");
            helper.setFrom(new InternetAddress("karansoni9752@gmail.com", "SmartCampus Team"));
            mailSender.send(mimeMessage);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendTrackEmail(String toEmail, String studentName, String trackingId) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");

            helper.setTo(toEmail);
            helper.setSubject("Complaint Submitted - Tracking ID");

            helper.setText("Dear " + studentName + ",\n\n" +
                    "Your complaint has been successfully submitted.\n" +
                    "Your Tracking ID is: " + trackingId + "\n\n" +
                    "You can use this ID to track the status of your complaint.\n\n" +
                    "Regards,\nSmartCampus Team");

            helper.setFrom(new InternetAddress("karansoni9752@gmail.com", "SmartCampus Team"));
            mailSender.send(mimeMessage);

           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
	public void deleteComplaintByTrack(String trackid) {
        complaintRepository.deleteByTrackingId(trackid);
    }



    

}
