package com.smartcamp.smartcamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import com.smartcamp.smartcamp.repo.EventRepo;
import com.smartcamp.smartcamp.model.Events;
@Service
@Transactional 
public class EventService {

    @Autowired
    private EventRepo eventRepository;

    // Add or Update Event
    public Events saveEvent(Events event) {
        return eventRepository.save(event);
    }

    // Get All Events
    public List<Events> getAllEvents() {
        return eventRepository.findAll();
    }

    // Get Single Event by ID
    public Optional<Events> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    // Delete Event by ID
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
    
    public void deleteEventByName(String eventName) {
        eventRepository.deleteByEventName(eventName);
    }

}
