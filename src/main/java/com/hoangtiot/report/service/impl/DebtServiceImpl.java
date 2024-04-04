package com.hoangtiot.report.service.impl;

import com.hoangtiot.report.model.Debt;
import com.hoangtiot.report.model.ShiftReport;
import com.hoangtiot.report.repository.DebtRepository;
import com.hoangtiot.report.service.DebtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DebtServiceImpl implements DebtService {
    @Autowired
    DebtRepository debtRepository;
    @Override
    public List<Debt> findAll() {
        return debtRepository.findAll();
    }

    @Override
    public List<Debt> findByReport(ShiftReport report) {
        return debtRepository.findByReport(report);
    }

    @Override
    public List<Debt> findByDate(String date) {
        return debtRepository.findByDate(date);
    }

    @Override
    public List<Debt> findByDebtor(String debtor) {
        return debtRepository.findByDebtor(debtor);
    }

    @Override
    public Optional<Debt> findById(int id) {
        return debtRepository.findById(id);
    }

    @Override
    public boolean addDebt(Debt debt) {
        debtRepository.save(debt);
        return true;
    }
}
