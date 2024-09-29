package com.businesssehyogi.BusinessSehyogi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    private int userId;
    private String firstName;
    private String lastName;
    @NotNull(message = "Username is required")
    private String userName;
    @NotNull(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;
    @NotNull(message = "Password is required")
    @Size(min = 6, message = "Password must be strong.")
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate DateOfBirth;
    private char gender;
    private BigDecimal contactNo;
    private String category;
    private String photo;
    private boolean visible;
    private boolean emailVerified;
    private boolean contactNoVerified;

    public User() {
        this.visible = true;
        this.emailVerified = false;
        this.contactNoVerified = false;
    }

    public User(int userId) {
        this.userId = userId;
    }

    public User(int userId, String firstName, String lastName, String userName, String email, String password, LocalDate dateOfBirth, char gender, BigDecimal contactNo, String category, String photo, boolean visible, boolean emailVerified, boolean contactNoVerified) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        DateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactNo = contactNo;
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
                ", userName='" + userName + '\'' +
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public BigDecimal getContactNo() {
        return contactNo;
    }

    public void setContactNo(BigDecimal contactNo) {
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
}
