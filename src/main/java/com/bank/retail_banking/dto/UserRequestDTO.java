package com.bank.retail_banking.dto;

public record UserRequestDTO(
        String username,
        String password,
        String email,
        String phone,
        Long bankId
) {}
