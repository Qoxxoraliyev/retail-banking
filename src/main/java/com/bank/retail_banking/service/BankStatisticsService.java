package com.bank.retail_banking.service;

import com.bank.retail_banking.dto.BankStatisticsResponseDTO;

import java.time.LocalDate;

public interface BankStatisticsService {

    BankStatisticsResponseDTO getDailyStatistics(LocalDate date);

    BankStatisticsResponseDTO getMonthlyStatistics(int year, int month);
}
