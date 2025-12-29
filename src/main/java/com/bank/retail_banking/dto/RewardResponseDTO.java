package com.bank.retail_banking.dto;

import com.bank.retail_banking.enums.RewardType;

import java.math.BigDecimal;

public record RewardResponseDTO(
        Long id,
        RewardType rewardType,
        BigDecimal amount,
        Long transactionId,
        Long creditCardId,
        Long userId,
        Long enterpriseId
) {}

