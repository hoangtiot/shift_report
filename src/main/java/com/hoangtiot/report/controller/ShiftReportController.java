package com.hoangtiot.report.controller;

import com.hoangtiot.report.dto.req.ShiftReportReqDto;
import com.hoangtiot.report.dto.res.*;
import com.hoangtiot.report.model.Debt;
import com.hoangtiot.report.model.Expense;
import com.hoangtiot.report.model.Income;
import com.hoangtiot.report.model.ShiftReport;
import com.hoangtiot.report.service.DebtService;
import com.hoangtiot.report.service.ExpenseService;
import com.hoangtiot.report.service.IncomeService;
import com.hoangtiot.report.service.ShiftReportService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shift_report")
public class ShiftReportController {
    @Autowired
    private ShiftReportService shiftReportService;
    @Autowired
    private DebtService debtService;
    @Autowired
    private ExpenseService expenseService;
    @Autowired
    private IncomeService incomeService;


    @GetMapping("/")
    public ApiResponse<List<ShiftReportResDto>> findAll(){
        List<ShiftReportResDto> listDto = new ArrayList<>();
        for (ShiftReport shiftReport : shiftReportService.findAll()){
            ShiftReportResDto dto = new ShiftReportResDto();
            dto.fromShiftReport(shiftReport);

            for (Debt debt : debtService.findByReport(shiftReport)){
                DebtResDto debtResDto = new DebtResDto();
                debtResDto.fromDebt(debt);
                dto.getDebts().add(debtResDto);
            }

            for (Expense expense : expenseService.findByReport(shiftReport)){
                ExpenseResDto expenseResDto = new ExpenseResDto();
                expenseResDto.fromExpense(expense);
                dto.getExpenses().add(expenseResDto);
            }

            for (Income income : incomeService.findByReport(shiftReport)){
                IncomeResDto incomeResDto = new IncomeResDto();
                incomeResDto.fromIncome(income);
                dto.getIncomes().add(incomeResDto);
            }

            listDto.add(dto);
        }
        return ApiResponse.<List<ShiftReportResDto>>builder().data(listDto).build();
    }

    @GetMapping("/{id}")
    public ApiResponse<ShiftReportResDto> findById(@PathVariable @Min(1) @NotNull int id){
        ShiftReportResDto dto = new ShiftReportResDto();
        ShiftReport shiftReport = shiftReportService.findById(id).orElse(null);
        dto.fromShiftReport(shiftReport);

        for (Debt debt : debtService.findByReport(shiftReport)){
            DebtResDto debtResDto = new DebtResDto();
            debtResDto.fromDebt(debt);
            dto.getDebts().add(debtResDto);
        }

        for (Expense expense : expenseService.findByReport(shiftReport)){
            ExpenseResDto expenseResDto = new ExpenseResDto();
            expenseResDto.fromExpense(expense);
            dto.getExpenses().add(expenseResDto);
        }

        for (Income income : incomeService.findByReport(shiftReport)){
            IncomeResDto incomeResDto = new IncomeResDto();
            incomeResDto.fromIncome(income);
            dto.getIncomes().add(incomeResDto);
        }

        return ApiResponse.<ShiftReportResDto>builder().data(dto).build();
    }

    @GetMapping("/by_date/{date}")
    public ApiResponse<List<ShiftReportResDto>> findByDate(@PathVariable @DateTimeFormat Date date){
        List<ShiftReportResDto> listDto = new ArrayList<>();
        ShiftReportResDto dto = new ShiftReportResDto();
        for (ShiftReport shiftReport : shiftReportService.findByDate(date)){
            dto = new ShiftReportResDto();
            dto.fromShiftReport(shiftReport);

            for (Debt debt : debtService.findByReport(shiftReport)){
                DebtResDto debtResDto = new DebtResDto();
                debtResDto.fromDebt(debt);
                dto.getDebts().add(debtResDto);
            }

            for (Expense expense : expenseService.findByReport(shiftReport)){
                ExpenseResDto expenseResDto = new ExpenseResDto();
                expenseResDto.fromExpense(expense);
                dto.getExpenses().add(expenseResDto);
            }

            for (Income income : incomeService.findByReport(shiftReport)){
                IncomeResDto incomeResDto = new IncomeResDto();
                incomeResDto.fromIncome(income);
                dto.getIncomes().add(incomeResDto);
            }

            listDto.add(dto);
        }
        return ApiResponse.<List<ShiftReportResDto>>builder().data(listDto).build();
    }

    @GetMapping("/month={month}+year={year}")
    public ApiResponse<List<ShiftReportResDto>> findByMonthYear(@PathVariable @Min(1) @Max(12) @NotNull int month, @PathVariable @Min(1970) @Max(2070) int year){
        List<ShiftReportResDto> listDto = new ArrayList<>();
        for (ShiftReport shiftReport : shiftReportService.findByMonth(month, year)){
            ShiftReportResDto dto = new ShiftReportResDto();
            dto.fromShiftReport(shiftReport);

            for (Debt debt : debtService.findByReport(shiftReport)){
                DebtResDto debtResDto = new DebtResDto();
                debtResDto.fromDebt(debt);
                dto.getDebts().add(debtResDto);
            }

            for (Expense expense : expenseService.findByReport(shiftReport)){
                ExpenseResDto expenseResDto = new ExpenseResDto();
                expenseResDto.fromExpense(expense);
                dto.getExpenses().add(expenseResDto);
            }

            for (Income income : incomeService.findByReport(shiftReport)){
                IncomeResDto incomeResDto = new IncomeResDto();
                incomeResDto.fromIncome(income);
                dto.getIncomes().add(incomeResDto);
            }

            listDto.add(dto);
        }
        return ApiResponse.<List<ShiftReportResDto>>builder().data(listDto).build();
    }

    @PostMapping("/add")
    public ApiResponse<ShiftReportResDto> add(@Valid @RequestBody ShiftReportReqDto shiftReportReqDto){
        ShiftReport shiftReport = new ShiftReport();
        shiftReportReqDto.toShiftReport(shiftReport);
        // set ShiftReport to debt, expense, income
        debtService.setShiftReport(shiftReportReqDto.getDebtIds(), shiftReport);
        expenseService.setShiftReport(shiftReportReqDto.getExpenseIds(), shiftReport);
        incomeService.setShiftReport(shiftReportReqDto.getIncomeIds(), shiftReport);

        ShiftReportResDto dto = new ShiftReportResDto();
        if (shiftReportService.addShiftReport(shiftReport)){
            dto.fromShiftReport(shiftReport);
        }
        return ApiResponse.<ShiftReportResDto>builder().data(dto).build();
    }
}
