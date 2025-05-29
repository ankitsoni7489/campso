package com.smartcamp.smartcamp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartcamp.smartcamp.model.Food;

import jakarta.transaction.Transactional;;

@Repository
public interface FoodRepo extends JpaRepository<Food, Long> {

	
	@Transactional
	void deleteByFoodName(String foodName);
    // Custom query methods (if needed) can be added here
}
