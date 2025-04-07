package com.example.booking.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    private Date date;

    private Long fees;

    private String status = "Available";

    public Slot(Integer id, Date date, Long fees, String status) {
        this.id = id;
        this.date = date;
        this.fees = fees;
        this.status = status;
    }

    public Slot() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getFees() {
        return fees;
    }

    public void setFees(Long fees) {
        this.fees = fees;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
