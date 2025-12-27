package com.bank.retail_banking.dto;

import com.bank.retail_banking.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionDTO(
        Long id,
        String transactionId,
        TransactionType type,
        BigDecimal amount,
        LocalDateTime timestamp,
        Long toAccountId,
        Long fromAccountId,
        Long accountId
){}
