package com.hoangtiot.report.controller;

import com.hoangtiot.report.model.ShiftReport;
import com.hoangtiot.report.service.ShiftReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shift_report")
public class ShiftReportController {
    @Autowired
    private ShiftReportService shiftReportService;

    @GetMapping("/")
    public ResponseEntity<List<ShiftReport>> findAll(){
        return ResponseEntity.ok().body(shiftReportService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShiftReport> findById(@PathVariable int id){
        return ResponseEntity.ok().body(shiftReportService.findById(id).orElse(null));
    }

    @GetMapping("/by_date/{date}")
    public ResponseEntity<List<ShiftReport>> findByDate(@PathVariable Date date){
        return ResponseEntity.ok().body(shiftReportService.findByDate(date));
    }

    @GetMapping("/month={month}+year={year}")
    public ResponseEntity<List<ShiftReport>> findByMonthYear(@PathVariable int month, @PathVariable int year){
        return ResponseEntity.ok().body(shiftReportService.findByMonth(month, year));
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody ShiftReport shiftReport){
        String rs = "Add failed";
        if (shiftReportService.addShiftReport(shiftReport))
            rs = "Add "+shiftReport.toString()+" successfully";
        return ResponseEntity.ok().body(rs);
    }
}
