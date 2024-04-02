package com.hoangtiot.report.repository;

import com.hoangtiot.report.model.Cash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashRepository extends JpaRepository<Cash, Integer> {
}
