package com.hoangtiot.report.service.impl;

import com.hoangtiot.report.model.Income;
import com.hoangtiot.report.model.ShiftReport;
import com.hoangtiot.report.repository.IncomeRepository;
import com.hoangtiot.report.service.IncomeService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@NoArgsConstructor
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    IncomeRepository incomeRepository;
    @Override
    public List<Income> findAll() {
        return incomeRepository.findAll();
    }

    @Override
    public List<Income> findByReport(ShiftReport report) {
        return incomeRepository.findByShiftReport(report);
    }

    @Override
    public Optional<Income> findById(int id) {
        return incomeRepository.findById(id);
    }

    @Override
    public boolean addIncome(Income income) {
        if(!incomeRepository.existsById(income.getId())){
            incomeRepository.save(income);
            return true;
        }
        return false;
    }

    @Override
    public List<Income> findByNullShiftReport() {
        return incomeRepository.findByShiftReport(null);
    }

    @Override
    public boolean setShiftReport(List<Integer> incomeIds, ShiftReport shiftReport) {
        for (Integer incomeId : incomeIds){
            Income income = incomeRepository.findById(incomeId).orElse(null);
            income.setShiftReport(shiftReport);
        }
        return true;
    }
}
