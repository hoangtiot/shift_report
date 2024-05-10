package com.hoangtiot.report.service;

import com.hoangtiot.report.model.Income;
import com.hoangtiot.report.model.ShiftReport;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IncomeService {
    List<Income> findAll();

    List<Income> findByReport(ShiftReport report);
    //by payment method
    Optional<Income> findById(int id);
    boolean addIncome(Income income);

    List<Income> findByNullShiftReport();

    boolean setShiftReport(List<Integer> incomeIds, ShiftReport shiftReport);
}
