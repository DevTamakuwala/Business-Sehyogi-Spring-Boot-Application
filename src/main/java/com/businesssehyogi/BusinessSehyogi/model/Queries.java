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

    private String query;

    private boolean isAnswer;

    private boolean isSolved;

    private String answer;

    // Default constructor
    public Queries() {
    }

    // Parameterized constructor
    public Queries(User user, LocalDateTime dateAndTime, String query, boolean isAnswer, boolean isSolved, String answer) {
        this.user = user;
        this.dateAndTime = dateAndTime;
        this.query = query;
        this.isAnswer = isAnswer;
        this.isSolved = isSolved;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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

    public boolean getIsAnswer() {
        return isAnswer;
    }

    public void setIsAnswer(boolean isAnswer) {
        this.isAnswer = isAnswer;
    }

    public boolean getIsSolved() {
        return isSolved;
    }

    public void setIsSolved(boolean isSolved) {
        this.isSolved = isSolved;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
