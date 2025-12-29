package com.bank.retail_banking.dto;


import com.bank.retail_banking.enums.OfferType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BankOffersRequestDTO(
        String offerName,
        String offerDescription,
        Long bankId,
        OfferType offerType,
        BigDecimal value,
        BigDecimal budget,
        LocalDate startDate,
        LocalDate endDate
){}
