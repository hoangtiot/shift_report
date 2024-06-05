package com.hoangtiot.report.service.impl;

import com.hoangtiot.report.model.Expense;
import com.hoangtiot.report.model.ShiftReport;
import com.hoangtiot.report.repository.ExpenseRepository;
import com.hoangtiot.report.service.ExpenseService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@NoArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;
    @Override
    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    @Override
    public List<Expense> findByReport(ShiftReport report) {
        return expenseRepository.findByShiftReport(report);
    }

    @Override
    public Optional<Expense> findById(int id) {
        return expenseRepository.findById(id);
    }

    @Override
    public boolean addExpense(Expense expense) {
        if (!expenseRepository.existsById(expense.getId())){
            expenseRepository.save(expense);
            return true;
        }
        return false;
    }

    @Override
    public List<Expense> findByNullShiftReport() {
        return expenseRepository.findByShiftReport(null);
    }

    @Override
    public boolean setShiftReport(List<Integer> expenseIds, ShiftReport shiftReport) {
        for (Integer expenseId : expenseIds){
            Expense expense = expenseRepository.findById(expenseId).orElse(null);
            expense.setShiftReport(shiftReport);
        }
        return true;
    }
}
