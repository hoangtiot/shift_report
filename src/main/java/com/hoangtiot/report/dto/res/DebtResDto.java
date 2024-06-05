package com.hoangtiot.report.dto.res;

import com.hoangtiot.report.model.Debt;
import lombok.Data;
import lombok.Setter;

import java.util.Date;

@Data
public class DebtResDto {
    private int id;
    private int billId;
    private String debtorName;
    private double amount;
    private Date time;

    public void fromDebt(Debt debt){
        this.id = debt.getId();
        this.billId = debt.getBillId();
        this.debtorName = debt.getDebtorName();
        this.amount = debt.getAmount();
        this.time = debt.getShiftReport()!=null?debt.getShiftReport().getTime():null;
    }
}
