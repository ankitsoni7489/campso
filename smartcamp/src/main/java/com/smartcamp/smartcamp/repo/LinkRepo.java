package com.smartcamp.smartcamp.repo;

import com.smartcamp.smartcamp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepo extends JpaRepository<Link, Long> {
    // You can add custom queries if needed
}
