package com.bank.retail_banking.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BankStatisticsResponseDTO(
        String period,
        LocalDateTime startDate,
        LocalDateTime endDate,

        BigDecimal totalIncome,
        BigDecimal totalExpense,
        BigDecimal netProfit,
        Long totalTransactions
) {
}
