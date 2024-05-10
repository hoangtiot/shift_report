package com.hoangtiot.report.service;

import com.hoangtiot.report.model.Debt;
import com.hoangtiot.report.model.ShiftReport;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface DebtService {
    List<Debt> findAll();

    List<Debt> findByReport(ShiftReport report);

    List<Debt> findByDate(Date date);

    List<Debt> findByDebtor(String debtor);

    Optional<Debt> findById(int id);

    boolean addDebt(Debt debt);

    List<Debt> findByNullShiftReport();

    boolean setShiftReport(List<Integer> debtIds, ShiftReport shiftReport);

    //update.. delete..
}
