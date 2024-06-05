package com.hoangtiot.report.controller;

import com.hoangtiot.report.service.CashService;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cash")
public class CashController {

    @Autowired
    private CashService cashService;

    @GetMapping("/")
    public ResponseEntity<Double> getCurrentCash(){
        return ResponseEntity.ok().body(cashService.getCashOnHand());
    }

    @PutMapping("/deposit/{amount}")
    public ResponseEntity<Double> deposit(@PathVariable @Min(1) @NotNull double amount){
        cashService.deposit(amount);
        return ResponseEntity.ok().body(cashService.getCashOnHand());
    }

    @PutMapping("/withdraw/{amount}")
    public ResponseEntity<Double> withdraw(@PathVariable @Min(1) @NotNull double amount){
        boolean rs = cashService.withdraw(amount);
        if (!rs) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(cashService.getCashOnHand());
    }
}
