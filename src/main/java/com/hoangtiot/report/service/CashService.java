package com.hoangtiot.report.service;

import org.springframework.stereotype.Service;

@Service
public interface CashService {
    double getCashOnHand();

    boolean deposit(double amount);

    boolean withdraw(double amount);
}
