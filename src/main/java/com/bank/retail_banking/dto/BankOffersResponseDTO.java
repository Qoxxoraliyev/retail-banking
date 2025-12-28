package com.bank.retail_banking.dto;

public record BankOffersResponseDTO(
        Long offerId,
        String offerName,
        String offerDescription,
        Long bankId
){}
