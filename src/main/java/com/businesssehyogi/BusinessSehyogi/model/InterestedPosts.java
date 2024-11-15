package com.businesssehyogi.BusinessSehyogi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_interested_posts")
public class InterestedPosts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int interestedPostId;

    @ManyToOne
    @JoinColumn(name = "investor_id", referencedColumnName = "investorId", nullable = false)
    @JsonBackReference
    private Investor investor;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "postId", nullable = false)
    @JsonBackReference
    private Post post;

    // Default constructor
    public InterestedPosts() {
    }

    // Parameterized constructor
    public InterestedPosts(Investor investor, Post post) {
        this.investor = investor;
        this.post = post;
    }

    // Getters and Setters
    public int getInterestedPostId() {
        return interestedPostId;
    }

    public void setInterestedPostId(int interestedPostId) {
        this.interestedPostId = interestedPostId;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
