//package com.businesssehyogi.BusinessSehyogi.model;
//
//import jakarta.persistence.*;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//@Entity
//@Table(name = "tblAlien")
//public class Alien {
//    @Id
//    private Integer aid;
//    private String aname;
//    private int age;
//    private BigDecimal mobile;
//    @OneToMany(mappedBy = "alien", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Result> results;
//
//    public Alien() {
//    }
//
//    public Alien(int aid, String aname) {
//        super();
//        this.aid = aid;
//        this.aname = aname;
//    }
//
//    public int getAid() {
//        return aid;
//    }
//
//    public void setAid(int aid) {
//        this.aid = aid;
//    }
//
//    public String getAname() {
//        return aname;
//    }
//
//    public void setAname(String aname) {
//        this.aname = aname;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public BigDecimal getMobile() {
//        return mobile;
//    }
//
//    public void setMobile(BigDecimal mobile) {
//        this.mobile = mobile;
//    }
//
//    @Override
//    public String toString() {
//        return "Alien [aid=" + aid + ", aname=" + aname + ", age=" + age + ", mobile=" + mobile + "]";
//    }
//}
