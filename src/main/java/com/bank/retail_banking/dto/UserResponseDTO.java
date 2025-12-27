package com.bank.retail_banking.dto;

import java.util.List;

public record UserResponseDTO(
        Long id,
        String username,
        String email,
        String phone,
        BankDTO bank,
        List<AccountResponseDTO> accounts
){}
