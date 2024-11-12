package com.businesssehyogi.BusinessSehyogi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_interest_area")
public class InterestArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int interestAreaId;

    private String areaName;

    @OneToMany(mappedBy = "areaOfPost", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Post> posts;

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
