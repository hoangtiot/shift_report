package com.hoangtiot.report.dto.req;

import com.hoangtiot.report.dto.res.DebtResDto;
import com.hoangtiot.report.dto.res.ExpenseResDto;
import com.hoangtiot.report.dto.res.IncomeResDto;
import com.hoangtiot.report.model.ShiftReport;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class ShiftReportReqDto {
    @Min(1)
    @NotNull(message = "Id can not be null")
    private int id;
    private List<Integer> incomeIds;
    private List<Integer> debtIds;
    private List<Integer> expenseIds;
    @Builder.Default
    private Date time = new Date(System.currentTimeMillis());

    public void toShiftReport(ShiftReport shiftReport){
        shiftReport.setId(this.id);
        shiftReport.setTime(this.time);
    }
}
