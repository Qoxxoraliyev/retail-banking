package com.bank.retail_banking.dto;

import java.math.BigDecimal;

public record CreditCardDTO(
        Long id,
        BigDecimal creditLimit,
        Long accountId
){}
