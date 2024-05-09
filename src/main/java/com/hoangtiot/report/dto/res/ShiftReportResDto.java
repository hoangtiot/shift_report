package com.hoangtiot.report.dto.res;

import com.hoangtiot.report.model.Debt;
import com.hoangtiot.report.model.Expense;
import com.hoangtiot.report.model.Income;
import com.hoangtiot.report.model.ShiftReport;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ShiftReportResDto {
    private int id;
    private List<IncomeResDto> incomes;
    private List<DebtResDto> debts;
    private List<ExpenseResDto> expenses;
    private Date time;

    public void fromShiftReport(ShiftReport shiftReport){
        this.id = shiftReport.getId();
        this.time = shiftReport.getTime();
    }
}
