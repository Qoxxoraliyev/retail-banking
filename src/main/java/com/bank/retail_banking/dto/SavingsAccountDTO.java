package com.bank.retail_banking.dto;

import java.math.BigDecimal;

public record SavingsAccountDTO(
        Long id,
        BigDecimal interestRate,
        Long accountId
){}
