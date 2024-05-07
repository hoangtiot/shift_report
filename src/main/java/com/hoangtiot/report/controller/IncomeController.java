package com.hoangtiot.report.controller;

import com.hoangtiot.report.dto.req.IncomeReqDto;
import com.hoangtiot.report.model.Income;
import com.hoangtiot.report.model.ShiftReport;
import com.hoangtiot.report.service.IncomeService;
import com.hoangtiot.report.service.ShiftReportService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    public ResponseEntity<List<Income>> findByReport(@PathVariable @Min(1) @NotNull int rp_id) {
        ShiftReport shiftReport = null;
        if (shiftReportService.isExist(rp_id)) {
            shiftReport = shiftReportService.findById(rp_id).orElse(null);
        }
        return ResponseEntity.ok().body(incomeService.findByReport(shiftReport));
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@Valid @RequestBody IncomeReqDto incomeReqDto){
        String rs = "Add failed";
        Income income = new Income();
        incomeReqDto.toIncome(income);
        ShiftReport shiftReport = null;
        if (shiftReportService.isExist(incomeReqDto.rp_id)) {
            shiftReport = shiftReportService.findById(incomeReqDto.rp_id).orElse(null);
            income.setShiftReport(shiftReport);
        }
        if (incomeService.addIncome(income))
            rs = "Add " +incomeReqDto.toString()+ "succesfully";
        return ResponseEntity.ok().body(rs);
    }
}
