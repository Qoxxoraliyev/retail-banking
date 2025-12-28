package com.bank.retail_banking.dto;

import com.bank.retail_banking.enums.EnterpriseName;

public record BankShoppingEnterpriseRequestDTO(
        EnterpriseName enterpriseName,
        String enterpriseDescription,
        Long parentEnterpriseId
){}
