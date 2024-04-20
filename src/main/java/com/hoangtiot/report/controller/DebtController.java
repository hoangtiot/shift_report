package com.hoangtiot.report.controller;

import com.hoangtiot.report.model.Debt;
import com.hoangtiot.report.model.ShiftReport;
import com.hoangtiot.report.service.DebtService;
import com.hoangtiot.report.service.ShiftReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/debt")
public class DebtController {
    @Autowired
    private DebtService debtService;
    @Autowired
    private ShiftReportService shiftReportService;

    @GetMapping("/")
    public ResponseEntity<List<Debt>> findAll(){
        return ResponseEntity.ok().body(debtService.findAll());
    }

    @GetMapping("/by_report/{rp_id}")
    public ResponseEntity<List<Debt>> findByReport(@PathVariable int rp_id){
        ShiftReport shiftReport = shiftReportService.findById(rp_id).orElse(null);
        return ResponseEntity.ok().body(debtService.findByReport(shiftReport));
    }

    @GetMapping("/by_debtor/{debtor}")
    public ResponseEntity<List<Debt>> findByDebtor(@PathVariable String debtor){
        return ResponseEntity.ok().body(debtService.findByDebtor(debtor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Debt> findById(@PathVariable int id){
        return ResponseEntity.ok().body(debtService.findById(id).orElse(null));
    }
}
