package com.smartcamp.smartcamp.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "lost_found_items")
public class LostFound {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private String name;

    private String category;

    private LocalDate date;

    private String location;

    @Column(length = 1000)
    private String description;

    private String contact;

    @Column(name = "status")
    private String status; // Values: "Lost" or "Found"

    // Constructors
    public LostFound() {}

    public LostFound(String name, String category, LocalDate date, String location, String description, String contact, String status) {
        this.name = name;
        this.category = category;
        this.date = date;
        this.location = location;
        this.description = description;
        this.contact = contact;
        this.status = status;
    }

    // Getters and Setters

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
