package com.businesssehyogi.BusinessSehyogi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likeId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "postId", nullable = false)
    private Post post;

    // Default constructor
    public Like() {
    }

    // Parameterized constructor
    public Like(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    // Getters and Setters
    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
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
}
