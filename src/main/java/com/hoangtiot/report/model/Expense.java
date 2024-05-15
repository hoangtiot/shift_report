package com.hoangtiot.report.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "expense")
public class Expense implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Column(name = "content")
    private String content;
    @Column(name = "amount")
    private double amount;
    @ManyToOne
    @JoinColumn(name = "report_id")
    private ShiftReport shiftReport;
}
