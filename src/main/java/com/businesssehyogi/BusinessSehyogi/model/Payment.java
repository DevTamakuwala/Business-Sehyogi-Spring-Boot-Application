package com.businesssehyogi.BusinessSehyogi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "tbl_payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Add @GeneratedValue for auto-increment
    private int payment_id;

    @ManyToMany
    @JoinTable(
            name = "user_payment",
            joinColumns = @JoinColumn(name = "payment_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users; // Many-to-Many relationship with User

    @ManyToMany
    @JoinTable(
            name = "post_payment",
            joinColumns = @JoinColumn(name = "payment_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id")
    )
    @JsonManagedReference
    private Set<Post> posts; // Many-to-Many relationship with Post

    private Double amount;
    private LocalDateTime paymentDateTime;
    private String transactionId; // From the payment gateway

    public Payment() {
    }

    public Payment(Set<User> users, Set<Post> posts, Double amount, LocalDateTime paymentDateTime, String transactionId) {
        this.users = users;
        this.posts = posts;
        this.amount = amount;
        this.paymentDateTime = paymentDateTime;
        this.transactionId = transactionId;
    }

    // Getters and Setters
    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
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
