package com.bank.retail_banking.service.impl;

import com.bank.retail_banking.entity.Bank;
import com.bank.retail_banking.repository.BankRepository;
import com.bank.retail_banking.service.BankService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Transactional
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    private final TransactionServiceImpl transactionService;

    @Override
    public Bank getById(Long id){
        return bankRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Bank not found"));
    }

    @Override
    public void decreaseBalance(Bank bank, BigDecimal amount){
        transactionService.monitorBankTransaction(bank,amount,"WITHDRAWAL");
        if (bank.getBalance().compareTo(amount)<0){
            throw new RuntimeException("There are insufficient funds in the bank balance");
        }
        bank.setBalance(bank.getBalance().subtract(amount));
    }


    @Override
    public Bank create(Bank bank){
        return bankRepository.save(bank);
    }


    @Override
    public void increaseBalance(Bank bank,BigDecimal amount){
        transactionService.monitorBankTransaction(bank, amount, "DEPOSIT");
        bank.setBalance(bank.getBalance().add(amount));
    }




}
