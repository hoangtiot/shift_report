package com.hoangtiot.report.service.impl;

import com.hoangtiot.report.model.Debt;
import com.hoangtiot.report.model.ShiftReport;
import com.hoangtiot.report.repository.DebtRepository;
import com.hoangtiot.report.service.DebtService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
@NoArgsConstructor
public class DebtServiceImpl implements DebtService {

    @Autowired
    DebtRepository debtRepository;
    @Override
    public List<Debt> findAll() {
        return debtRepository.findAll();
    }

    @Override
    public List<Debt> findByReport(ShiftReport report) {
        return debtRepository.findByShiftReport(report);
    }

    @Override
    public List<Debt> findByDate(Date date) {
        return debtRepository.findByShiftReportTime(date);
    }

    @Override
    public List<Debt> findByDebtor(String debtor) {
        return debtRepository.findByDebtorName(debtor);
    }

    @Override
    public Optional<Debt> findById(int id) {
        return debtRepository.findById(id);
    }

    @Override
    public boolean addDebt(Debt debt) {
        if (!debtRepository.existsById(debt.getId())){
            debtRepository.save(debt);
            return true;
        }
        return false;
    }

    @Override
    public List<Debt> findByNullShiftReport() {
        return debtRepository.findByShiftReport(null);
    }

    @Override
    public boolean setShiftReport(List<Integer> debtIds, ShiftReport shiftReport) {
        for (int debtId : debtIds){
            Debt debt = debtRepository.findById(debtId).orElse(null);
            debt.setShiftReport(shiftReport);
        }
        return true;
    }
}
