package com.businesssehyogi.BusinessSehyogi.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_query")
public class Queries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int queryId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = false)
    private User user;

    private LocalDateTime dateAndTime;

    private boolean isAnswer;

    private boolean isSolved;

    // Default constructor
    public Queries() {
    }

    // Parameterized constructor
    public Queries(User user, LocalDateTime dateAndTime, boolean isAnswer, boolean isSolved) {
        this.user = user;
        this.dateAndTime = dateAndTime;
        this.isAnswer = isAnswer;
        this.isSolved = isSolved;
    }

    // Getters and Setters
    public int getQueryId() {
        return queryId;
    }

    public void setQueryId(int queryId) {
        this.queryId = queryId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public boolean isAnswer() {
        return isAnswer;
    }

    public void setAnswer(boolean isAnswer) {
        this.isAnswer = isAnswer;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean isSolved) {
        this.isSolved = isSolved;
    }
}
