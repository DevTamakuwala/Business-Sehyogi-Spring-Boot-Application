package com.businesssehyogi.BusinessSehyogi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_interest_area")
public class InterestArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int interestAreaId;

    private String areaName;

    public InterestArea(int interestAreaId, String areaName) {
        this.interestAreaId = interestAreaId;
        this.areaName = areaName;
    }

    public InterestArea() {
    }

    public int getAreaId() {
        return interestAreaId;
    }

    public void setAreaId(int areaId) {
        this.interestAreaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
