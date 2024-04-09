package com.hoangtiot.report.service.impl;

import com.hoangtiot.report.model.ShiftReport;
import com.hoangtiot.report.repository.ShiftReportRepository;
import com.hoangtiot.report.service.ShiftReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class ShiftReportServiceImpl implements ShiftReportService {

    @Autowired
    ShiftReportRepository shiftReportRepository;
    @Override
    public List<ShiftReport> findAll() {
        return shiftReportRepository.findAll();
    }

    @Override
    public List<ShiftReport> findByDate(Date date) {
        return shiftReportRepository.findByTime(date);
    }

    @Override
    public List<ShiftReport> findByMonth(int month, int year) {
        return shiftReportRepository.findByYearAndMonth(year, month);
    }

    @Override
    public Optional<ShiftReport> findById(int id) {
        return shiftReportRepository.findById(id);
    }

    @Override
    public boolean addShiftReport(ShiftReport report) {
        shiftReportRepository.save(report);
        return true;
    }
}
