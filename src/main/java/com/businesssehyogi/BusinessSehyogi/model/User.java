package com.businesssehyogi.BusinessSehyogi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    private int userId;
    private String firstName;
    private String lastName;
    @NotNull(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;
    @Size(min = 6, message = "Password must be strong.")
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate DateOfBirth;
    private char gender;
    private BigInteger contactNo;
    private Long noOfConnections;
    private String category;
    private String photo;
    private boolean visible;
    private boolean emailVerified;
    private boolean contactNoVerified;
    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss")
    private LocalDateTime dateTimeOfRegistration;
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
////    @JsonManagedReference
//    private List<Post> posts;

    public User() {
        this.visible = true;
        this.emailVerified = false;
        this.contactNoVerified = false;
    }

    public User(int userId) {
        this.userId = userId;
    }

    public User(int userId, String firstName, String lastName, String email, String password, LocalDate dateOfBirth, char gender, BigInteger contactNo, Long noOfConnections, String category, String photo, boolean visible, boolean emailVerified, boolean contactNoVerified) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        DateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactNo = contactNo;
        this.noOfConnections = noOfConnections;
        this.category = category;
        this.photo = photo;
        this.visible = visible;
        this.emailVerified = emailVerified;
        this.contactNoVerified = contactNoVerified;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", DateOfBirth=" + DateOfBirth +
                ", gender=" + gender +
                ", contactNo=" + contactNo +
                ", category='" + category + '\'' +
                ", photo='" + photo + '\'' +
                ", visible=" + visible +
                ", emailVerified=" + emailVerified +
                ", contactNoVerified=" + contactNoVerified +
                '}';
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public LocalDateTime getDateTimeOfRegistration() {
        return dateTimeOfRegistration;
    }

    public void setDateTimeOfRegistration(LocalDateTime dateTimeOfRegistration) {
        this.dateTimeOfRegistration = dateTimeOfRegistration;
    }

    public boolean isContactNoVerified() {
        return contactNoVerified;
    }

    public void setContactNoVerified(boolean contactNoVerified) {
        this.contactNoVerified = contactNoVerified;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public BigInteger getContactNo() {
        return contactNo;
    }

    public void setContactNo(BigInteger contactNo) {
        this.contactNo = contactNo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Long getNoOfConnections() {
        return noOfConnections;
    }

    public void setNoOfConnections(Long noOfConnections) {
        this.noOfConnections = noOfConnections;
    }

//    public List<Post> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(List<Post> posts) {
//        this.posts = posts;
//    }
}
