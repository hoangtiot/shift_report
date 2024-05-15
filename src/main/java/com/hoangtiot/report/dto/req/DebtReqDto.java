package com.hoangtiot.report.dto.req;

import com.hoangtiot.report.model.Debt;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.Date;

@Getter
public class DebtReqDto {
    @Min(1)
    @NotNull(message = "Id can not be null")
    private int id;
    @NotNull(message = "Bill Id can not be null")
    private int billId;
    @NotNull(message = "Debtor name can not be null")
    private String debtorName;
    @Min(0)
    @NotNull(message = "Amount can not be null")
    private double amount;


    public void toDebt(Debt debt){
        debt.setId(this.id);
        debt.setBillId(this.billId);
        debt.setDebtorName(this.debtorName);
        debt.setAmount(this.amount);
        debt.setShiftReport(null);
    }
}
