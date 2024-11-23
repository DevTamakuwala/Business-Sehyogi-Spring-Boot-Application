package com.businesssehyogi.BusinessSehyogi.DTO;

import jakarta.persistence.Column;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class HistoryRequest {

    private int user;

    @Column(name = "old_email", length = 100)
    private String oldEmail;

    @Column(name = "old_password", length = 100)
    private String oldPassword;

    @Column(name = "old_contact")
    private BigInteger oldContact;

    private LocalDateTime dateAndTime;

    public HistoryRequest(int user, String oldEmail, String oldPassword, BigInteger oldContact, LocalDateTime dateAndTime) {
        this.user = user;
        this.oldEmail = oldEmail;
        this.oldPassword = oldPassword;
        this.oldContact = oldContact;
        this.dateAndTime = dateAndTime;
    }

    public HistoryRequest() {
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
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

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
