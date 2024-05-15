package com.hoangtiot.report.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import com.hoangtiot.report.constant.PaymentMethod;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "income")
public class Income implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @Column(name = "amount")
    private double amount;
    @ManyToOne
    @JoinColumn(name = "report_id")
    private ShiftReport shiftReport;
}
