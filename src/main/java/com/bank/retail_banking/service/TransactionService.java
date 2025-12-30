package com.bank.retail_banking.service;

import com.bank.retail_banking.entity.Bank;
import com.bank.retail_banking.entity.Transaction;

import java.math.BigDecimal;

public interface TransactionService {

    void monitorTransaction(Transaction transaction);

    void monitorBankTransaction(Bank bank, BigDecimal amount, String type);


}
