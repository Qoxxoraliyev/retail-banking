package com.bank.retail_banking.service;

import com.bank.retail_banking.entity.BankOffers;

import java.math.BigDecimal;

public interface BankOffersService {

    BankOffers createOffer(Long bankId,String offerName,String offerDescription,BigDecimal amount);

    void deleteOffer(Long offerId);

}
