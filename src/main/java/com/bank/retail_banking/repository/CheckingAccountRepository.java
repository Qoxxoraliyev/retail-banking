package com.bank.retail_banking.repository;

import com.bank.retail_banking.entity.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CheckingAccountRepository extends JpaRepository<CheckingAccount,Long> {

    Optional<CheckingAccount> findByAccountId(Long accountId);

}
