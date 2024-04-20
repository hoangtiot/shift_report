package com.hoangtiot.report.controller;

import com.hoangtiot.report.model.Income;
import com.hoangtiot.report.model.ShiftReport;
import com.hoangtiot.report.service.IncomeService;
import com.hoangtiot.report.service.ShiftReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/income")
public class IncomeController {
    @Autowired
    private IncomeService incomeService;
    @Autowired
    private ShiftReportService shiftReportService;

    @GetMapping("/")
    public ResponseEntity<List<Income>> findAll(){
        return ResponseEntity.ok().body(incomeService.findAll());
    }

    @GetMapping("/by_report/{rp_id}")
    public ResponseEntity<List<Income>> findByReport(@PathVariable int rp_id){
        ShiftReport shiftReport = shiftReportService.findById(rp_id).orElse(null);
        return ResponseEntity.ok().body(incomeService.findByReport(shiftReport));
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Income income){
        incomeService.addIncome(income);
        return ResponseEntity.ok().body("" +  income.getAmount() + income.getPaymentMethod());
    }
}
