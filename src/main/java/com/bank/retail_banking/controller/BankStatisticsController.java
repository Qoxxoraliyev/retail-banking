package com.bank.retail_banking.controller;

import com.bank.retail_banking.dto.BankStatisticsResponseDTO;
import com.bank.retail_banking.service.BankStatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/statistics")
@RequiredArgsConstructor
public class BankStatisticsController {

    private final BankStatisticsService bankStatisticsService;

    @GetMapping("/daily")
    public BankStatisticsResponseDTO getDailyStatistics(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return bankStatisticsService.getDailyStatistics(date);
    }


    @GetMapping("/monthly")
    public BankStatisticsResponseDTO getMonthlyStatistics(
            @RequestParam("year") int year,
            @RequestParam("month") int month
    ) {
        return bankStatisticsService.getMonthlyStatistics(year, month);
    }
}
