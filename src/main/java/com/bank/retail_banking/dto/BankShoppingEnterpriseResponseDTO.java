package com.bank.retail_banking.dto;

import com.bank.retail_banking.enums.EnterpriseName;

public record BankShoppingEnterpriseResponseDTO(
        Long id,
        EnterpriseName enterpriseName,
        String enterpriseDescription,
        Long parentEnterpriseId
){}
