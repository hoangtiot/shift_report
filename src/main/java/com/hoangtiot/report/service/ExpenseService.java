package com.hoangtiot.report.service;

import com.hoangtiot.report.model.Expense;
import com.hoangtiot.report.model.ShiftReport;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ExpenseService {
    List<Expense> findAll();

    List<Expense> findByReport(ShiftReport report);

    Optional<Expense> findById(int id);

    boolean addExpense(Expense expense);

    List<Expense> findByNullShiftReport();

    boolean setShiftReport(List<Integer> expenseIds, ShiftReport shiftReport);

    //update delete
}
