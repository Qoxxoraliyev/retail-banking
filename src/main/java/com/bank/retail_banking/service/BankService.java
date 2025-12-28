package com.bank.retail_banking.service;
import com.bank.retail_banking.entity.Bank;
import java.math.BigDecimal;

public interface BankService {

    Bank getById(Long id);

    void decreaseBalance(Bank bank, BigDecimal amount);

    void increaseBalance(Bank bank,BigDecimal amount);

}
