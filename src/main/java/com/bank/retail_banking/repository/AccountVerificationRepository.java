package com.bank.retail_banking.repository;

import com.bank.retail_banking.entity.AccountVerification;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface AccountVerificationRepository extends JpaRepository<AccountVerification,Long> {

    Optional<AccountVerification> findByAccountId(Long accountId);

    Optional<AccountVerification> findByVerificationCode(String verificationCode);
}
