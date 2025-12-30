package com.bank.retail_banking.service.impl;

import com.bank.retail_banking.entity.Bank;
import com.bank.retail_banking.entity.Transaction;
import com.bank.retail_banking.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private static final BigDecimal MAX_SINGLE_TRANSACTION=BigDecimal.valueOf(100_000);

    @Override
    public void monitorTransaction(Transaction transaction){
        BigDecimal amount=transaction.getAmount();

        if (amount.compareTo(MAX_SINGLE_TRANSACTION)>0){
            throw new RuntimeException("Transaction amount exceeds allowed limit");
        }

        if (transaction.getFromAccount()!=null
        && transaction.getFromAccount().getBalance().compareTo(amount)<0){
            throw new RuntimeException("Insufficient funds for transaction ID: "+transaction.getTransactionId());
        }
    }



    @Override
    public void monitorBankTransaction(Bank bank, BigDecimal amount, String type) {
        if (amount.compareTo(MAX_SINGLE_TRANSACTION) > 0) {
            throw new RuntimeException(type + " amount exceeds allowed limit");
        }

        if ("WITHDRAWAL".equals(type) && bank.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient funds in bank for " + type);
        }
    }


}
