package com.hoangtiot.report.service;

import com.hoangtiot.report.model.Debt;
import com.hoangtiot.report.model.ShiftReport;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DebtService {
    List<Debt> findAll();

    List<Debt> findByReport(ShiftReport report);

    List<Debt> findByDate(String date);

    List<Debt> findByDebtor(String debtor);

    Optional<Debt> findById(int id);

    boolean addDebt(Debt debt);

    //update.. delete..
}
