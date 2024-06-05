package com.hoangtiot.report.dto.res;

import com.hoangtiot.report.model.Category;
import com.hoangtiot.report.model.Expense;
import com.hoangtiot.report.model.ShiftReport;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Setter;

import java.util.Date;

@Data
public class ExpenseResDto {
    private int id;

    private String categoryName;

    private String content;

    private double amount;
    private Date time;

    public void fromExpense(Expense expense){
        this.id = expense.getId();
        this.categoryName = expense.getCategory().getName();
        this.content = expense.getContent();
        this.amount = expense.getAmount();
        this.time = expense.getShiftReport()!=null?expense.getShiftReport().getTime():null;
    }
}
