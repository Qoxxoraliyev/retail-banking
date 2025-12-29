package com.bank.retail_banking.service.impl;

import com.bank.retail_banking.entity.Bank;
import com.bank.retail_banking.entity.BankOffers;
import com.bank.retail_banking.enums.OfferType;
import com.bank.retail_banking.repository.BankOffersRepository;
import com.bank.retail_banking.service.BankOffersService;
import com.bank.retail_banking.service.BankService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class BankOffersServiceImpl implements BankOffersService {

    private final BankOffersRepository offersRepository;

    private final BankService bankService;

    @Override
    public BankOffers createOffer(
            Long bankId,
            String name,
            String description,
            OfferType type,
            BigDecimal value,
            BigDecimal budget,
            LocalDate start,
            LocalDate end
    ) {
        Bank bank = bankService.getById(bankId);

        bankService.decreaseBalance(bank, budget);

        BankOffers offer = new BankOffers();
        offer.setOfferName(name);
        offer.setOfferDescription(description);
        offer.setOfferType(type);
        offer.setValue(value);
        offer.setBudget(budget);
        offer.setStartDate(start);
        offer.setEndDate(end);
        offer.setActive(true);
        offer.setBank(bank);

        return offersRepository.save(offer);
    }


    @Override
    public void deleteOffer(Long offerId) {
        BankOffers offer = offersRepository.findById(offerId)
                .orElseThrow(() -> new RuntimeException("Offer not found"));

        bankService.increaseBalance(
                offer.getBank(),
                offer.getBudget()
        );

        offersRepository.delete(offer);
    }

}
