package com.bank.retail_banking.service.impl;
import com.bank.retail_banking.dto.BankStatisticsResponseDTO;
import com.bank.retail_banking.entity.Transaction;
import com.bank.retail_banking.repository.TransactionRepository;
import com.bank.retail_banking.service.BankStatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BankStatisticsServiceImpl implements BankStatisticsService {

    private final TransactionRepository transactionRepository;

    @Override
    public BankStatisticsResponseDTO getDailyStatistics(LocalDate date) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(LocalTime.MAX);

        return calculateStatistics(start, end, "DAILY");
    }

    @Override
    public BankStatisticsResponseDTO getMonthlyStatistics(int year, int month) {
        LocalDate firstDay = LocalDate.of(year, month, 1);
        LocalDateTime start = firstDay.atStartOfDay();
        LocalDateTime end = firstDay.plusMonths(1).atStartOfDay().minusNanos(1);

        return calculateStatistics(start, end, "MONTHLY");
    }

    private BankStatisticsResponseDTO calculateStatistics(LocalDateTime start, LocalDateTime end, String period) {
        List<Transaction> transactions = transactionRepository.findAllByTimestampBetween(start, end);

        BigDecimal totalIncome = transactions.stream()
                .filter(t -> t.getType() == com.bank.retail_banking.enums.TransactionType.DEPOSIT
                        || t.getType() == com.bank.retail_banking.enums.TransactionType.LOAN_REPAYMENT)
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalExpense = transactions.stream()
                .filter(t -> t.getType() == com.bank.retail_banking.enums.TransactionType.WITHDRAWAL
                        || t.getType() == com.bank.retail_banking.enums.TransactionType.LOAN_DISBURSEMENT)
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal netProfit = totalIncome.subtract(totalExpense);
        long totalTransactions = transactions.size();

        return new BankStatisticsResponseDTO(
                period,
                start,
                end,
                totalIncome,
                totalExpense,
                netProfit,
                totalTransactions
        );
    }
}
