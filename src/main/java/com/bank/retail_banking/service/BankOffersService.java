package com.bank.retail_banking.service;

import com.bank.retail_banking.entity.BankOffers;
import com.bank.retail_banking.enums.OfferType;

import java.math.BigDecimal;
import java.time.LocalDate;


public interface BankOffersService {

        BankOffers createOffer(
                Long bankId,
                String name,
                String description,
                OfferType type,
                BigDecimal value,
                BigDecimal budget,
                LocalDate start,
                LocalDate end
        );

        void deleteOffer(Long offerId);
    }

