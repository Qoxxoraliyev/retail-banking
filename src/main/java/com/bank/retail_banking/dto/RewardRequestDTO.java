package com.bank.retail_banking.dto;

import com.bank.retail_banking.enums.RewardType;

import java.math.BigDecimal;

public record RewardRequestDTO(
        RewardType rewardType,
        BigDecimal amount,
        Long transactionId,
        Long creditCardId,
        Long userId,
        Long enterpriseId
){}
