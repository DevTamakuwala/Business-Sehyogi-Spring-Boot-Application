package com.businesssehyogi.BusinessSehyogi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_investor_interested_areas")
public class InvestorInterestedArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int investorInterestedAreaId;

    @ManyToOne
    @JoinColumn(name = "area_id", referencedColumnName = "interestAreaId", nullable = false)
    private InterestArea area;

    @ManyToOne
    @JoinColumn(name = "investor_id", referencedColumnName = "investorId", nullable = false)
    private Investor investor;

    // Default constructor
    public InvestorInterestedArea() {
    }

    // Parameterized constructor
    public InvestorInterestedArea(InterestArea area, Investor investor) {
        this.area = area;
        this.investor = investor;
    }

    // Getters and Setters
    public int getInvestorInterestedAreaId() {
        return investorInterestedAreaId;
    }

    public void setInvestorInterestedAreaId(int investorInterestedAreaId) {
        this.investorInterestedAreaId = investorInterestedAreaId;
    }

    public InterestArea getArea() {
        return area;
    }

    public void setArea(InterestArea area) {
        this.area = area;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }
}
