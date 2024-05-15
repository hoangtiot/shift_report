package com.hoangtiot.report.dto.req;

import com.hoangtiot.report.constant.PaymentMethod;
import com.hoangtiot.report.model.Income;
import com.hoangtiot.report.util.EnumValue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class IncomeReqDto implements Serializable {
    @Min(1)
    @NotNull(message = "Id can not be null")
    private int id;
    @NotNull(message = "Payment method can not be null")
    @EnumValue(name = "paymentMethod", enumClass = PaymentMethod.class)
    private PaymentMethod paymentMethod;
    @NotNull(message = "Amount can not be null")
    @Min(0)
    private double amount;
    @NotNull(message = "Shift report Id can not be null")
    @Min(1)
    public int rp_id;

    public void toIncome(Income income){
        income.setId(this.id);
        income.setAmount(this.amount);
        income.setPaymentMethod(this.paymentMethod);
        income.setShiftReport(null);
    }
}
