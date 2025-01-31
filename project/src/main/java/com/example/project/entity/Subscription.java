package com.example.project.entity;

import com.example.project.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int noSessionsPerformed;

    private int noSessionsAvailable;

    private Status status;

    private LocalDate startDate;

    private LocalDate endDate;

    private int price;

    @OneToOne(mappedBy = "subscription")
    private Student student;

    public Subscription() {}

    public Subscription(int noSessionsPerformed, int noSessionsAvailable, Status status, LocalDate startDate, LocalDate endDate, int price) {
        this.noSessionsPerformed = noSessionsPerformed;
        this.noSessionsAvailable = noSessionsAvailable;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNoSessionsPerformed() {
        return noSessionsPerformed;
    }

    public void setNoSessionsPerformed(int noSessionsPerformed) {
        this.noSessionsPerformed = noSessionsPerformed;
    }

    public int getNoSessionsAvailable() {
        return noSessionsAvailable;
    }

    public void setNoSessionsAvailable(int noSessionsAvailable) {
        this.noSessionsAvailable = noSessionsAvailable;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
