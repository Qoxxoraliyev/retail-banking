package com.bank.retail_banking.dto;

import java.math.BigDecimal;

public record AccountResponseDTO(
        Long id,
        String accountNumber,
        BigDecimal balance
){}
