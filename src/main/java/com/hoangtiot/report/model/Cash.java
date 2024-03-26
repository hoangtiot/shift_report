package com.hoangtiot.report.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "cash")
public class Cash implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cash_on_hand", nullable = false)
    private double cashOnHand;
}
