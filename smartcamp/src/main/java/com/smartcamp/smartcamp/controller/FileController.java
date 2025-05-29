package com.smartcamp.smartcamp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smartcamp.smartcamp.repo.*;
import com.smartcamp.smartcamp.model.*;
import com.smartcamp.smartcamp.service.*;

import jakarta.servlet.http.HttpSession;

import java.io.IOException;


import org.springframework.core.io.ByteArrayResource;


@Controller
@RequestMapping("/upload")
public class FileController {

    @Autowired
    private UploadFileRepo uploadedFileRepository;
    
   
    
    
    @Autowired
    private FileService fileService;
    
    @GetMapping("")
    public String showUploadForm() {
        return "file"; // upload.html
    }

    @SuppressWarnings("null")
	@PostMapping("")
    public String handleFileUpload(
            @RequestParam("title") String title,
            @RequestParam("subject") String subject,
            @RequestParam("uploadedBy") String uploadedBy,
            @RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) {

        try {
            UploadFile uploadFile = new UploadFile();
            uploadFile.setTitle(title);
            uploadFile.setSubject(subject);
            uploadFile.setUploadedBy(uploadedBy);
            if (!file.getContentType().equals("application/pdf")) {
                throw new IllegalArgumentException("Only PDF files are allowed.");
            }
            else {
            	uploadFile.setFileType(file.getContentType());
            }
//            uploadFile.setFileType(file.getContentType());
            uploadFile.setFileData(file.getBytes());
            uploadFile.setFileSize(file.getSize());

            uploadedFileRepository.save(uploadFile);

            redirectAttributes.addFlashAttribute("message", "File uploaded successfully!");
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("message", "File upload failed: " + e.getMessage());
        }

        return "redirect:/home"; // or wherever your upload page is
    }
    
    @GetMapping("/files")
    public String listFiles(Model model, HttpSession session) {
    	String choice = (String) session.getAttribute("choice");
        model.addAttribute("choice", choice);
        model.addAttribute("files", fileService.getAllFiles());
        return "file_list";
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer id) {
        UploadFile file = fileService.getFileById(id);

        
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getTitle() + ".pdf\"")
                .contentType(MediaType.parseMediaType(file.getFileType()))
                .contentLength(file.getFileSize())
                .body(new ByteArrayResource(file.getFileData()));
    }
    
    @GetMapping("/delete-by-name")
    public String deleteByName(@RequestParam("track") String trackingId, HttpSession session, Model model) {
    	String choice = (String) session.getAttribute("choice");
    	
    	model.addAttribute("choice", choice);
    	if("admin".equals(choice))
        {
    		fileService.deleteFileByTrack(trackingId);
            return "redirect:/upload/files"; 
        }
        return "error"; 
        
    }
    
}
