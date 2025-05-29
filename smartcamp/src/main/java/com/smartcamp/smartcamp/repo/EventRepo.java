package com.smartcamp.smartcamp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartcamp.smartcamp.model.Events;

@Repository
public interface EventRepo extends JpaRepository<Events, Long> {

	void deleteByEventName(String eventName);
    // JpaRepository provides: save(), findById(), findAll(), deleteById(), etc.
}
