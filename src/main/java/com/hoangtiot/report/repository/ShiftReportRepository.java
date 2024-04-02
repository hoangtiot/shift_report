package com.hoangtiot.report.repository;

import com.hoangtiot.report.model.ShiftReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftReportRepository extends JpaRepository<ShiftReport, Integer> {
}
