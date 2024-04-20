package com.hoangtiot.report.controller;

import com.hoangtiot.report.model.Expense;
import com.hoangtiot.report.model.ShiftReport;
import com.hoangtiot.report.service.ExpenseService;
import com.hoangtiot.report.service.ShiftReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/expense")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;
    @Autowired
    private ShiftReportService shiftReportService;

    @GetMapping("/")
    public ResponseEntity<List<Expense>> findAll(){
        return ResponseEntity.ok().body(expenseService.findAll());
    }

    @GetMapping("/by_report/{rp_id}")
    public ResponseEntity<List<Expense>> findByReport(@PathVariable int rp_id){
        ShiftReport shiftReport = shiftReportService.findById(rp_id).orElse(null);
        return ResponseEntity.ok().body(expenseService.findByReport(shiftReport));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> findById(@PathVariable int id){
        return ResponseEntity.ok().body(expenseService.findById(id).orElse(null));
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Expense expense){
        expenseService.addExpense(expense);
        return ResponseEntity.ok().body(expense.getContent());
    }
}