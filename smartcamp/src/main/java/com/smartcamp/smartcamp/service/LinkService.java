package com.smartcamp.smartcamp.service;



import com.smartcamp.smartcamp.model.Link;
import com.smartcamp.smartcamp.repo.LinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkService {

    @Autowired
    private LinkRepo scholarshipRepository;

    // Add a new scholarship
    public Link addScholarship(Link link) {
        return scholarshipRepository.save(link);
    }

    // Get all scholarships
    public List<Link> getAllScholarships() {
        return scholarshipRepository.findAll();
    }

    // Delete scholarship by title
    public String deleteScholarshipByTitle(String title) {
        List<Link> links = scholarshipRepository.findAll();

        boolean deleted = false;

        for (Link link : links) {
            if (link.getTitle().equalsIgnoreCase(title)) {
                scholarshipRepository.delete(link);
                deleted = true;
            }
        }

        return deleted ? "Scholarship(s) deleted successfully." : "Scholarship not found.";
    }
}
