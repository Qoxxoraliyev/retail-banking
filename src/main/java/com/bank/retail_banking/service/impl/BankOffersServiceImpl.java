package com.bank.retail_banking.service.impl;

import com.bank.retail_banking.entity.Bank;
import com.bank.retail_banking.entity.BankOffers;
import com.bank.retail_banking.entity.CreditCard;
import com.bank.retail_banking.enums.OfferType;
import com.bank.retail_banking.repository.BankOffersRepository;
import com.bank.retail_banking.repository.CreditCardRepository;
import com.bank.retail_banking.service.BankOffersService;
import com.bank.retail_banking.service.BankService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BankOffersServiceImpl implements BankOffersService {

    private final BankOffersRepository offersRepository;

    private final BankService bankService;

    private final CreditCardRepository cardRepository;

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
    public BankOffers updateOffer(
            Long offerId,
            String name,
            String description,
            OfferType type,
            BigDecimal value,
            BigDecimal budget,
            LocalDate start,
            LocalDate end,
            Boolean active
    ){
        BankOffers offer=offersRepository.findById(offerId)
                .orElseThrow(()->new RuntimeException("Offer not found"));

        BigDecimal oldBudget=offer.getBudget();
        if (budget!=null && !budget.equals(oldBudget)){
            BigDecimal diff=budget.subtract(oldBudget);
            if (diff.compareTo(BigDecimal.ZERO)>0){
                bankService.decreaseBalance(offer.getBank(),diff.abs());
            }
            else {
                bankService.increaseBalance(offer.getBank(),diff.abs());
            }
            offer.setBudget(budget);
        }

        if (name!=null) offer.setOfferName(name);
        if (description!=null) offer.setOfferDescription(description);
        if (type!=null) offer.setOfferType(type);
        if (value!=null) offer.setValue(value);
        if (start!=null) offer.setStartDate(start);
        if (end!=null) offer.setEndDate(end);
        if (active!=null) offer.setActive(active);
        return offersRepository.save(offer);
    }

    @Override
    public BankOffers patchOffer(
            Long offerId,
            String name,
            String description,
            OfferType type,
            BigDecimal value,
            BigDecimal budget,
            LocalDate start,
            LocalDate end,
            Boolean active
    ){
        return updateOffer(
                offerId,
                name,
                description,
                type,
                value,
                budget,
                start,
                end,
                active
        );
    }


    @Override
    public void assignOfferToCards(Long offerId, List<Long> cardIds) {

        BankOffers offer = offersRepository.findById(offerId)
                .orElseThrow(() -> new RuntimeException("Offer not found"));

        List<CreditCard> cards = cardRepository.findAllById(cardIds);

        if (cards.size() != cardIds.size()) {
            throw new RuntimeException("Some cards not found");
        }

        for (CreditCard card : cards) {
            if (!card.getBank().getId().equals(offer.getBank().getId())) {
                throw new RuntimeException("Card does not belong to this bank");
            }
        }

        offer.getCreditCards().addAll(cards);
        offersRepository.save(offer);
    }


    @Override
    public void removeOfferFromCards(Long offerId,List<Long> cardIds){
        BankOffers offer=offersRepository.findById(offerId)
                .orElseThrow((()->new RuntimeException("Offer not found")));
        List<CreditCard> cards=cardRepository.findAllById(cardIds);
        offer.getCreditCards().removeAll(cards);
        offersRepository.save(offer);
    }


    @Override
    public void updateOffersCards(Long offerId,List<Long> cardIds){
        BankOffers offer=offersRepository.findById(offerId)
                .orElseThrow(()->new RuntimeException("Offer not found"));
        List<CreditCard> cards=cardRepository.findAllById(cardIds);
        offer.setCreditCards(cards);
        offersRepository.save(offer);
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
