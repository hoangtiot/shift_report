package com.hoangtiot.report.service.impl;

import com.hoangtiot.report.model.Expense;
import com.hoangtiot.report.model.ShiftReport;
import com.hoangtiot.report.repository.ExpenseRepository;
import com.hoangtiot.report.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    ExpenseRepository expenseRepository;
    @Override
    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    @Override
    public List<Expense> findByReport(ShiftReport report) {
        return expenseRepository.findByReport(report);
    }

    @Override
    public Optional<Expense> findById(int id) {
        return expenseRepository.findById(id);
    }

    @Override
    public boolean addExpense(Expense expense) {
        expenseRepository.save(expense);
        return true;
    }
}
