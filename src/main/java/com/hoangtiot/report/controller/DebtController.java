package com.hoangtiot.report.controller;

import com.hoangtiot.report.dto.req.DebtReqDto;
import com.hoangtiot.report.dto.res.ApiResponse;
import com.hoangtiot.report.dto.res.DebtResDto;
import com.hoangtiot.report.model.Debt;
import com.hoangtiot.report.model.ShiftReport;
import com.hoangtiot.report.service.DebtService;
import com.hoangtiot.report.service.ShiftReportService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ApiResponse<List<DebtResDto>> findAll(){
        List<DebtResDto> listDto = new ArrayList<>();
        for (Debt debt : debtService.findAll()){
            DebtResDto dto = new DebtResDto();
            dto.fromDebt(debt);
            listDto.add(dto);
        }
        return ApiResponse.<List<DebtResDto>>builder().data(listDto).build();
    }

    @GetMapping("/by_report/{rp_id}")
    public ApiResponse<List<DebtResDto>> findByReport(@PathVariable @Min(1) @NotNull int rp_id) {
        List<DebtResDto> listDto = new ArrayList<>();
        if (shiftReportService.isExist(rp_id)) {
            ShiftReport shiftReport = shiftReportService.findById(rp_id).orElse(null);
            for (Debt debt : debtService.findByReport(shiftReport)){
                DebtResDto dto = new DebtResDto();
                dto.fromDebt(debt);
                listDto.add(dto);
            }
        }
        return ApiResponse.<List<DebtResDto>>builder().data(listDto).build();
    }

    @GetMapping("/by_debtor/{debtor}")
    public ApiResponse<List<DebtResDto>> findByDebtor(@PathVariable @NotBlank String debtor){
        List<DebtResDto> listDto = new ArrayList<>();
            for (Debt debt : debtService.findByDebtor(debtor)){
                DebtResDto dto = new DebtResDto();
                dto.fromDebt(debt);
                listDto.add(dto);
        }
        return ApiResponse.<List<DebtResDto>>builder().data(listDto).build();
    }

    @GetMapping("/null_shift_report")
    public ApiResponse<List<DebtResDto>> findByDebtor(){
        List<DebtResDto> listDto = new ArrayList<>();
        for (Debt debt : debtService.findByNullShiftReport()){
            DebtResDto dto = new DebtResDto();
            dto.fromDebt(debt);
            listDto.add(dto);
        }
        return ApiResponse.<List<DebtResDto>>builder().data(listDto).build();
    }

    @GetMapping("/{id}")
    public ApiResponse<DebtResDto> findById(@PathVariable @Min(1) @NotNull int id){
        DebtResDto dto = new DebtResDto();
        dto.fromDebt(debtService.findById(id).orElse(null));

        return ApiResponse.<DebtResDto>builder().data(dto).build();
    }

    @PostMapping("/add")
    public ApiResponse<DebtResDto> add(@Valid @RequestBody DebtReqDto debtReqDto){
        Debt debt = new Debt();
        debtReqDto.toDebt(debt);
        DebtResDto dto = new DebtResDto();
        if (debtService.addDebt(debt)) {
            dto.fromDebt(debt);
        }
        return ApiResponse.<DebtResDto>builder().data(dto).build();
    }
}
