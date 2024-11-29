package com.businesssehyogi.BusinessSehyogi.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tbl_investors")
public class Investor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int investorId;
    private BigDecimal totalInvestedAmount;
    private String topInvestedCompanies;

    @OneToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User userId;

    public Investor() {
    }

    public Investor(BigDecimal totalInvestedAmount, String topInvestedCompanies, User userId) {
//        this.investorId = investorId;
        this.totalInvestedAmount = totalInvestedAmount;
        this.topInvestedCompanies = topInvestedCompanies;
        this.userId = userId;
    }

    public int getInvestorId() {
        return investorId;
    }

    public void setInvestorId(int investorId) {
        this.investorId = investorId;
    }

    public BigDecimal getTotalInvestedAmount() {
        return totalInvestedAmount;
    }

    public void setTotalInvestedAmount(BigDecimal totalInvestedAmount) {
        this.totalInvestedAmount = totalInvestedAmount;
    }

    public String getTopInvestedCompanies() {
        return topInvestedCompanies;
    }

    public void setTopInvestedCompanies(String topInvestedCompanies) {
        this.topInvestedCompanies = topInvestedCompanies;
    }

    @Override
    public String toString() {
        return "Investor{" +
                "investorId=" + investorId +
                ", totalInvestedAmount=" + totalInvestedAmount +
                ", topInvestedCompanies='" + topInvestedCompanies + '\'' +
//                ", userId=" + userId +
                '}';
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
