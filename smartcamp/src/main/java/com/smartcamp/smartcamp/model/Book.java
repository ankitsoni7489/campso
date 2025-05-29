package com.smartcamp.smartcamp.model;



import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String author;
    private String category;
    private boolean availability;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public Book(int id, String title, String author, String category, boolean availability) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
		this.availability = availability;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Getters and Setters
}
