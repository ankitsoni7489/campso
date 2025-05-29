package com.smartcamp.smartcamp.model;



import jakarta.persistence.*;

@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facultyId;

    @Column(name = "faculty_name", nullable = false, length = 50)
    private String facultyName;

    @Column(name = "department", nullable = false, length = 50)
    private String department;

    @Column(name = "faculty_subject", nullable = false, length = 50)
    private String facultySubject;

    @Column(name = "contact", length = 20)
    private String contact;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "address", nullable = false, length = 50)
    private String address;

    @Column(name = "publication", length = 50)
    private String publication;

    @Column(name = "experince")
    private Integer experince;

    
    @Lob
    private byte[] imageData;

    // getter/setter
    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    
    
    @Transient
    private String base64Image;

    // getters and setters
    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
    // Constructors
    public Faculty() {
    }

    public Faculty(String facultyName, String department, String facultySubject, String contact,
                   String email, String address, String publication, Integer experince) {
        this.facultyName = facultyName;
        this.department = department;
        this.facultySubject = facultySubject;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.publication = publication;
        this.experince = experince;
    }

    // Getters and Setters

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFacultySubject() {
        return facultySubject;
    }

    public void setFacultySubject(String facultySubject) {
        this.facultySubject = facultySubject;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public Integer getExperince() {
        return experince;
    }

    public void setExperince(Integer experince) {
        this.experince = experince;
    }
}

