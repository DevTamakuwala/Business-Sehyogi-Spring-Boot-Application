package com.businesssehyogi.BusinessSehyogi.DTO;

import java.time.LocalDateTime;

public class PaymentRequest {

    private int users; // Many-to-Many relationship with User
    private int posts; // Many-to-Many relationship with Post
    private Double amount;
    private LocalDateTime paymentDateTime;
    private String transactionId; // From the payment gateway

    public PaymentRequest(int users, int posts, Double amount, LocalDateTime paymentDateTime, String transactionId) {
        this.users = users;
        this.posts = posts;
        this.amount = amount;
        this.paymentDateTime = paymentDateTime;
        this.transactionId = transactionId;
    }

    public PaymentRequest() {
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public int getPosts() {
        return posts;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDateTime() {
        return paymentDateTime;
    }

    public void setPaymentDateTime(LocalDateTime paymentDateTime) {
        this.paymentDateTime = paymentDateTime;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
