package com.hoangtiot.report.repository;

import com.hoangtiot.report.model.Debt;
import com.hoangtiot.report.model.ShiftReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DebtRepository extends JpaRepository<Debt, Integer> {
    List<Debt> findByReport(ShiftReport report);

    List<Debt> findByReportTime(Date time);

    List<Debt> findByDebtorName(String debtorName);
}
