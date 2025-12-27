package com.bank.retail_banking.dto;

import java.math.BigDecimal;

public record CheckingAccountDTO(
        Long id,
        BigDecimal overdraftLimit,
        Long accountId
) {}
