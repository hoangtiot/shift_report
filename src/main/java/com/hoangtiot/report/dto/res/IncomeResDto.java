package com.hoangtiot.report.dto.res;

import com.hoangtiot.report.constant.PaymentMethod;
import com.hoangtiot.report.model.Income;
import lombok.Data;
import lombok.Setter;

import java.util.Date;

@Data
public class IncomeResDto {
    private int id;
    private PaymentMethod paymentMethod;
    private double amount;
    private Date time;

    public void fromIncome(Income income){
        this.id = income.getId();
        this.paymentMethod = income.getPaymentMethod();
        this.amount = income.getAmount();
        this.time = income.getShiftReport()!=null?income.getShiftReport().getTime():null;
    }
}
