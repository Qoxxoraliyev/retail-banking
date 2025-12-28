package com.bank.retail_banking.dto;

import java.math.BigDecimal;

public record FDDTO(
        Long id,
        BigDecimal minBalance,
        Long accountId
){}
