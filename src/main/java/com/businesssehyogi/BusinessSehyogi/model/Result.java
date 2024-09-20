//package com.businesssehyogi.BusinessSehyogi.model;
//
//import jakarta.persistence.*;
//
//@Entity
//public class Result {
//
//    @ManyToOne()
//    @JoinColumn(name = "alienId")
//    private Alien alien;
//    @Id
//    private int id;
//    private int marks;
//
//    public Result() {
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getMarks() {
//        return marks;
//    }
//
//    public void setMarks(int marks) {
//        this.marks = marks;
//    }
//
//    public Alien getAlien() {
//        return alien;
//    }
//
//    public void setAlien(Alien alien) {
//        this.alien = alien;
//    }
//
//    @Override
//    public String toString() {
//        return "Result{" +
//                "id=" + id +
//                ", marks=" + marks +
//                '}';
//    }
//}
