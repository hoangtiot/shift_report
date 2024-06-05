package com.hoangtiot.report.service.impl;

import com.hoangtiot.report.model.Cash;
import com.hoangtiot.report.repository.CashRepository;
import com.hoangtiot.report.service.CashService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class CashServiceImpl implements CashService {

    @Autowired
    CashRepository cashRepository;
    @Override
    public double getCashOnHand() {
        return cashRepository.findById(1).orElse(null).getCashOnHand();
    }

    @Override
    public boolean deposit(double amount) {
        Cash c = cashRepository.findById(1).orElse(null);
        c.setCashOnHand(c.getCashOnHand()+amount);
        cashRepository.save(c);
        return true;
    }

    @Override
    public boolean withdraw(double amount) {
        Cash c = cashRepository.findById(1).orElse(null);
        if (c.getCashOnHand() < amount) {
            return false;
        }
        c.setCashOnHand(c.getCashOnHand()-amount);
        cashRepository.save(c);
        return true;
    }
}
