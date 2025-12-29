package com.bank.retail_banking.repository;
import com.bank.retail_banking.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {

    Optional<CreditCard> findByAccountId(Long accountId);

    boolean existsByAccountId(Long accountId);

}
