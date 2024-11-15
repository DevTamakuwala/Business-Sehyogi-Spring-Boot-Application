package com.businesssehyogi.BusinessSehyogi.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "postId", nullable = false)
    private Post post;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_and_time", nullable = false)
    private Date dateAndTime;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = false)
    private User user;

    @Column(name = "visible", nullable = false)
    private boolean visible;

    // Default constructor
    public Comment() {
    }

    // Parameterized constructor
    public Comment(Post post, Date dateAndTime, User user, boolean visible) {
        this.post = post;
        this.dateAndTime = dateAndTime;
        this.user = user;
        this.visible = visible;
    }

    // Getters and Setters
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
