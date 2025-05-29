package com.smartcamp.smartcamp.repo;



import com.smartcamp.smartcamp.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ComplaintRepo extends JpaRepository<Complaint, Integer> {
    List<Complaint> findByStudentId(String studentId);
    
    Optional<Complaint> findByTrackingId(String trackingId);

    void deleteByTrackingId(String trackingId);
}

