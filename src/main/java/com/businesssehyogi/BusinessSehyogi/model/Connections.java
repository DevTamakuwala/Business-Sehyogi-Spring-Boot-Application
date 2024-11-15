package com.businesssehyogi.BusinessSehyogi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_connections")
public class Connections {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int connectionId;

    @ManyToOne
    @JoinColumn(name = "founder_user_id", referencedColumnName = "userId", nullable = false)
    private User founderUser;

    @ManyToOne
    @JoinColumn(name = "co_founder_or_investor_user_id", referencedColumnName = "userId", nullable = false)
    private User coFounderOrInvestorUser;

    @Column(name = "status", nullable = false)
    private String status; // can be "approved", "rejected", or "pending"

    // Default constructor
    public Connections() {
    }

    // Parameterized constructor
    public Connections(User founderUser, User coFounderOrInvestorUser, String status) {
        this.founderUser = founderUser;
        this.coFounderOrInvestorUser = coFounderOrInvestorUser;
        this.status = status;
    }

    // Getters and Setters
    public int getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(int connectionId) {
        this.connectionId = connectionId;
    }

    public User getFounderUser() {
        return founderUser;
    }

    public void setFounderUser(User founderUser) {
        this.founderUser = founderUser;
    }

    public User getCoFounderOrInvestorUser() {
        return coFounderOrInvestorUser;
    }

    public void setCoFounderOrInvestorUser(User coFounderOrInvestorUser) {
        this.coFounderOrInvestorUser = coFounderOrInvestorUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
