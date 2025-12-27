package com.bank.retail_banking.dto;



import java.math.BigDecimal;
import java.util.List;

public record BankResponseDTO(
        Long id,
        BigDecimal balance,
        List<BankOfferDTO> bankOffers,
        List<UserDTO> users
){}
