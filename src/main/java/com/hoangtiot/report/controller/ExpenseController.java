package com.hoangtiot.report.controller;

import com.hoangtiot.report.dto.res.ApiResponse;
import com.hoangtiot.report.dto.res.ExpenseResDto;
import com.hoangtiot.report.model.Expense;
import com.hoangtiot.report.model.ShiftReport;
import com.hoangtiot.report.service.ExpenseService;
import com.hoangtiot.report.service.ShiftReportService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ApiResponse<List<ExpenseResDto>> findAll(){
        List<ExpenseResDto> listDto = new ArrayList<>();
        for (Expense expense : expenseService.findAll()){
            ExpenseResDto dto = new ExpenseResDto();
            dto.fromExpense(expense);
            listDto.add(dto);
        }
        return ApiResponse.<List<ExpenseResDto>>builder().data(listDto).build();
    }

    @GetMapping("/by_report/{rp_id}")
    public ApiResponse<List<ExpenseResDto>> findByReport(@PathVariable @Min(1) @NotNull int rp_id) {
        List<ExpenseResDto> listDto = new ArrayList<>();
        for (Expense expense : expenseService.findByReport(shiftReportService.findById(rp_id).orElse(null))){
            ExpenseResDto dto = new ExpenseResDto();
            dto.fromExpense(expense);
            listDto.add(dto);
        }
        return ApiResponse.<List<ExpenseResDto>>builder().data(listDto).build();
    }

    @GetMapping("/{id}")
    public ApiResponse<ExpenseResDto> findById(@PathVariable @Min(1) @NotNull int id){
        ExpenseResDto dto = new ExpenseResDto();
        dto.fromExpense(expenseService.findById(id).orElse(null));
        return ApiResponse.<ExpenseResDto>builder().data(dto).build();
    }

//    @PostMapping("/add")
//    public ResponseEntity<String> add(@Valid @RequestBody Expense expense){
//        String rs = "Add failed";
//        if (expenseService.addExpense(expense))
//            rs = "Add "+expense.toString()+" successfully";
//        return ResponseEntity.ok().body(rs);
//    }
}
