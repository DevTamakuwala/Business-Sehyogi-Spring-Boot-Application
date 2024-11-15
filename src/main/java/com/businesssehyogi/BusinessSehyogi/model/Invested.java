package com.businesssehyogi.BusinessSehyogi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_invested")
public class Invested {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int investId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = false)
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "postId", nullable = false)
    @JsonBackReference
    private Post post;

    @ManyToOne
    @JoinColumn(name = "investor_id", referencedColumnName = "investorId", nullable = false)
    @JsonBackReference
    private Investor investor;

    // Default constructor
    public Invested() {
    }

    // Parameterized constructor
    public Invested(User user, Post post, Investor investor) {
        this.user = user;
        this.post = post;
        this.investor = investor;
    }

    // Getters and Setters
    public int getInvestId() {
        return investId;
    }

    public void setInvestId(int investId) {
        this.investId = investId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }
}
