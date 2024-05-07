package com.hoangtiot.report.controller;

import com.hoangtiot.report.model.Debt;
import com.hoangtiot.report.model.ShiftReport;
import com.hoangtiot.report.service.DebtService;
import com.hoangtiot.report.service.ShiftReportService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Debt>> findByReport(@PathVariable @Min(1) @NotNull int rp_id) {
        ShiftReport shiftReport = null;
        if (shiftReportService.isExist(rp_id)) {
            shiftReport = shiftReportService.findById(rp_id).orElse(null);
        }
        return ResponseEntity.ok().body(debtService.findByReport(shiftReport));
    }

    @GetMapping("/by_debtor/{debtor}")
    public ResponseEntity<List<Debt>> findByDebtor(@PathVariable @NotBlank String debtor){
        return ResponseEntity.ok().body(debtService.findByDebtor(debtor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Debt> findById(@PathVariable @Min(1) @NotNull int id){
        return ResponseEntity.ok().body(debtService.findById(id).orElse(null));
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@Valid @RequestBody Debt debt){
        String rs = "Add failed";
        if (debtService.addDebt(debt))
            rs = "Add "+debt.toString()+" successfully";
        return ResponseEntity.ok().body(rs);
    }
}
