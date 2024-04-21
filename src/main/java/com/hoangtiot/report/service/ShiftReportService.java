package com.hoangtiot.report.service;

import com.hoangtiot.report.model.ShiftReport;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface ShiftReportService {
    List<ShiftReport> findAll();

    List<ShiftReport> findByDate(Date date);

    List<ShiftReport> findByMonth(int month, int year);

    Optional<ShiftReport> findById(int id);

    boolean addShiftReport(ShiftReport report);

    boolean isExist(int id);
}
