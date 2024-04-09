package com.hoangtiot.report.repository;

import com.hoangtiot.report.model.ShiftReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ShiftReportRepository extends JpaRepository<ShiftReport, Integer> {
    List<ShiftReport> findByTime(Date date);

    @Query("SELECT r FROM ShiftReport r WHERE YEAR(r.time) = :year AND MONTH(r.time) = :month")
    List<ShiftReport> findByYearAndMonth(@Param("year") int year, @Param("month") int month);


}
