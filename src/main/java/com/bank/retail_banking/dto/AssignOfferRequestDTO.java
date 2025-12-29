package com.bank.retail_banking.dto;

import java.util.List;

public record AssignOfferRequestDTO(
        List<Long> cardIds
) {}
