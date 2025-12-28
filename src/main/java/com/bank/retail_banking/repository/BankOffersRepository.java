package com.bank.retail_banking.repository;

import com.bank.retail_banking.entity.BankOffers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankOffersRepository extends JpaRepository<BankOffers,Long> {

    List<BankOffers> findByBankId(Long bankId);

}
