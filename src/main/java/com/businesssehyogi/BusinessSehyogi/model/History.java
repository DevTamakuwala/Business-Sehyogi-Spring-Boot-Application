package com.businesssehyogi.BusinessSehyogi.model;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int historyId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = false)
    private User user;

    @Column(name = "old_email", length = 100)
    private String oldEmail;

    @Column(name = "old_password", length = 100)
    private String oldPassword;

    @Column(name = "old_contact")
    private BigInteger oldContact;

    @Column(name = "change_date")
    private LocalDateTime changeDate;

    // Default constructor
    public History() {
    }

    // Parameterized constructor
    public History(User user, String oldEmail, String oldPassword, BigInteger oldContact, LocalDateTime changeDate) {
        this.user = user;
        this.oldEmail = oldEmail;
        this.oldPassword = oldPassword;
        this.oldContact = oldContact;
        this.changeDate = changeDate;
    }

    // Getters and Setters
    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOldEmail() {
        return oldEmail;
    }

    public void setOldEmail(String oldEmail) {
        this.oldEmail = oldEmail;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public BigInteger getOldContact() {
        return oldContact;
    }

    public void setOldContact(BigInteger oldContact) {
        this.oldContact = oldContact;
    }

    public LocalDateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDateTime changeDate) {
        this.changeDate = changeDate;
    }
}
