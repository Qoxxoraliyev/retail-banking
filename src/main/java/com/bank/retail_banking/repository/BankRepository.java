package com.bank.retail_banking.repository;

import com.bank.retail_banking.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank,Long> {

}
