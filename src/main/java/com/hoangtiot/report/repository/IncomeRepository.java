package com.hoangtiot.report.repository;

import com.hoangtiot.report.model.Income;
import com.hoangtiot.report.model.ShiftReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Integer> {
    List<Income> findByShiftReport(ShiftReport report);
}
