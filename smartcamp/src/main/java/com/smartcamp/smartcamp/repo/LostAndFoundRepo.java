package com.smartcamp.smartcamp.repo;



import com.smartcamp.smartcamp.model.LostFound;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LostAndFoundRepo extends JpaRepository<LostFound, Long> {
}
