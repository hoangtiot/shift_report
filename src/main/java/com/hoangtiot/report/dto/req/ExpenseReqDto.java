package com.hoangtiot.report.dto.req;

import com.hoangtiot.report.model.Expense;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Getter
public class ExpenseReqDto {
    @Min(1)
    @NotNull(message = "Id can not be null")
    private int id;
    @Min(1)
    @NotNull(message = "Category can not be null")
    private int categoryId;

    private String content;
    @Min(0)
    @NotNull(message = "Amount can not be null")
    private double amount;
    private Date time;

    public void toExpense(Expense expense){
        expense.setId(this.id);
        expense.setAmount(this.amount);
        expense.setContent(this.content);
        expense.setShiftReport(null);
    }
}
