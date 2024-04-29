package com.hoangtiot.report.repository;

import com.hoangtiot.report.model.Expense;
import com.hoangtiot.report.model.ShiftReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    List<Expense> findByShiftReport(ShiftReport report);
}
