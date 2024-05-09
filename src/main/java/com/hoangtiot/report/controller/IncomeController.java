package com.hoangtiot.report.controller;

import com.hoangtiot.report.dto.req.IncomeReqDto;
import com.hoangtiot.report.dto.res.ApiResponse;
import com.hoangtiot.report.dto.res.IncomeResDto;
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

import java.util.ArrayList;
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
    public ApiResponse<List<IncomeResDto>> findAll(){
        List<IncomeResDto> listDto = new ArrayList<>();
        for (Income income : incomeService.findAll()){
            IncomeResDto dto = new IncomeResDto();
            dto.fromIncome(income);
            listDto.add(dto);
        }
        return ApiResponse.<List<IncomeResDto>>builder().data(listDto).build();
    }

    @GetMapping("/by_report/{rp_id}")
    public ApiResponse<List<IncomeResDto>> findByReport(@PathVariable @Min(1) @NotNull int rp_id) {
        List<IncomeResDto> listDto = new ArrayList<>();
        for (Income income : incomeService.findByReport(shiftReportService.findById(rp_id).orElse(null))){
            IncomeResDto dto = new IncomeResDto();
            dto.fromIncome(income);
            listDto.add(dto);
        }
        return ApiResponse.<List<IncomeResDto>>builder().data(listDto).build();
    }

//    @PostMapping("/add")
//    public ResponseEntity<String> add(@Valid @RequestBody IncomeReqDto incomeReqDto){
//        String rs = "Add failed";
//        Income income = new Income();
//        incomeReqDto.toIncome(income);
//        ShiftReport shiftReport = null;
//        if (shiftReportService.isExist(incomeReqDto.rp_id)) {
//            shiftReport = shiftReportService.findById(incomeReqDto.rp_id).orElse(null);
//            income.setShiftReport(shiftReport);
//        }
//        if (incomeService.addIncome(income))
//            rs = "Add " +incomeReqDto.toString()+ "succesfully";
//        return ResponseEntity.ok().body(rs);
//    }
}
