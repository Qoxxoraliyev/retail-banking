package com.bank.retail_banking.service.impl;

import com.bank.retail_banking.entity.Bank;
import com.bank.retail_banking.entity.BankOffers;
import com.bank.retail_banking.repository.BankOffersRepository;
import com.bank.retail_banking.service.BankOffersService;
import com.bank.retail_banking.service.BankService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Transactional
public class BankOffersServiceImpl implements BankOffersService {

    private final BankOffersRepository offersRepository;

    private final BankService bankService;

    @Override
    public BankOffers createOffer(Long bankId,String offerName,String offerDescription,BigDecimal amount){
        Bank bank=bankService.getById(bankId);
        bankService.decreaseBalance(bank,amount);

        BankOffers offer=new BankOffers();
        offer.setOfferName(offerName);
        offer.setOfferDescription(offerDescription);
        offer.setAmount(amount);
        offer.setBank(bank);
        return offersRepository.save(offer);
    }

    @Override
    public void deleteOffer(Long offerId){
        BankOffers offer=offersRepository.findById(offerId)
                .orElseThrow(()->
                        new RuntimeException("Offer not found"));

        bankService.increaseBalance(
                offer.getBank(),
                offer.getAmount()
        );

        offersRepository.delete(offer);
    }

}
