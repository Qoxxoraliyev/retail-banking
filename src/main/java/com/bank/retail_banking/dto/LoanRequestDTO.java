package com.bank.retail_banking.dto;

import java.math.BigDecimal;

public record LoanRequestDTO(
        BigDecimal principal,
        BigDecimal interestRate,
        Integer termInMonth,
        Long accountId
){}
