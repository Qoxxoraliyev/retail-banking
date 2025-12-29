package com.bank.retail_banking.service;

import com.bank.retail_banking.entity.BankOffers;
import com.bank.retail_banking.enums.OfferType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


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


        BankOffers updateOffer(
                Long offerId,
                String name,
                String description,
                OfferType type,
                BigDecimal value,
                BigDecimal budget,
                LocalDate start,
                LocalDate end,
                Boolean active
        );


        BankOffers patchOffer(
                Long offerId,
                String name,
                String description,
                OfferType type,
                BigDecimal value,
                BigDecimal budget,
                LocalDate start,
                LocalDate end,
                Boolean active
        );

        void assignOfferToCards(Long offerId, List<Long> cardIds);

        void removeOfferFromCards(Long offerId,List<Long> cardsId);

        void updateOffersCards(Long offerId,List<Long> cardIds);

        void deleteOffer(Long offerId);

    }

