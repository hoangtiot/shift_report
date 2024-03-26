package com.hoangtiot.report.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "debt")
public class Debt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "bill_id")
    private int billId;
    @Column(name = "debtor_name")
    private String debtorName;
    @Column(name = "amount")
    private double amount;
    @ManyToOne
    @JoinColumn(name = "report_id")
    private ShiftReport shiftReport;
}
