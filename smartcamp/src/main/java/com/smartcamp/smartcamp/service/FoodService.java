package com.smartcamp.smartcamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import com.smartcamp.smartcamp.repo.FoodRepo;
import com.smartcamp.smartcamp.model.Food;
@Service
@Transactional 
public class FoodService {

    @Autowired
    private FoodRepo foodRepo;

    // Add or Update Event
    public Food saveFood(Food food) {
        return foodRepo.save(food);
    }

    // Get All Events
    public List<Food> getAllFood() {
        return foodRepo.findAll();
    }

    // Get Single Event by ID
    public Optional<Food> getFoodById(Long id) {
        return foodRepo.findById(id);
    }

    // Delete Event by ID
    public void deleteFood(Long id) {
    	foodRepo.deleteById(id);
    }
    
    public void deleteFoodByName(String name) {
        foodRepo.deleteByFoodName(name);
    }

	

}
