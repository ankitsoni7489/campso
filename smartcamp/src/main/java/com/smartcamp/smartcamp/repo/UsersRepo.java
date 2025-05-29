package com.smartcamp.smartcamp.repo;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartcamp.smartcamp.model.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
    
    
    Optional<Users> findByEmail(String email);
    Optional<Users> findByResetToken(String resetToken);
}
