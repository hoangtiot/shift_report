package com.hoangtiot.report.service;

import com.hoangtiot.report.model.ShiftReport;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ShiftReportService {
    List<ShiftReport> findAll();

    List<ShiftReport> findByDate(String date);

    List<ShiftReport> findByMonth(String month);

    Optional<ShiftReport> findById(int id);

    boolean addShiftReport(ShiftReport report);
}
