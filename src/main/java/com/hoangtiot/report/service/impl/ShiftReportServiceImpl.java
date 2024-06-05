package com.hoangtiot.report.service.impl;

import com.hoangtiot.report.model.ShiftReport;
import com.hoangtiot.report.repository.ShiftReportRepository;
import com.hoangtiot.report.service.ShiftReportService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
@NoArgsConstructor
public class ShiftReportServiceImpl implements ShiftReportService {

    @Autowired
    ShiftReportRepository shiftReportRepository;
    @Override
    public List<ShiftReport> findAll() {
        return shiftReportRepository.findAll();
    }

    @Override
    public List<ShiftReport> findByDate(Date date) {
        if (date.before(new Date(System.currentTimeMillis()))){
            return null;
        }
        return shiftReportRepository.findByTime(date);
    }

    @Override
    public List<ShiftReport> findByMonth(int month, int year) {
        if (month<1 || month>12 || year<1990 || year>2100){
            return null;
        }
        return shiftReportRepository.findByYearAndMonth(year, month);
    }

    @Override
    public Optional<ShiftReport> findById(int id) {
        return shiftReportRepository.findById(id);
    }

    @Override
    public boolean addShiftReport(ShiftReport report) {
        if(!shiftReportRepository.existsById(report.getId())){
            shiftReportRepository.save(report);
            return true;
        }
        return false;
    }

    @Override
    public boolean isExist(int id) {
        return shiftReportRepository.existsById(id);
    }
}
