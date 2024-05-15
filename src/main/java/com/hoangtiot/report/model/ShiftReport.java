package com.hoangtiot.report.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "shift_report")
public class ShiftReport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "shiftReport")
    private List<Income> incomes;
    @OneToMany(mappedBy = "shiftReport")
    private List<Debt> debts;
    @OneToMany(mappedBy = "shiftReport")
    private List<Expense> expenses;
    @Column(name = "time")
    private Date time;
}
