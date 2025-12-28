package com.bank.retail_banking.dto;

import com.bank.retail_banking.enums.LoanStatus;

import java.math.BigDecimal;

public record LoanResponseDTO(
        Long id,
        BigDecimal principal,
        BigDecimal interestRate,
        Integer termInMonth,
        LoanStatus status,
        Long accountId
){}
