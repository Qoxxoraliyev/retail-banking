package com.bank.retail_banking.dto;

import com.bank.retail_banking.entity.Loan;

public record BankOffersRequestDTO(
        String offerName,
        String OfferDescription,
        Loan bankId
){}
