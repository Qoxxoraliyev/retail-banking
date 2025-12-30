package com.bank.retail_banking.repository;

import com.bank.retail_banking.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    List<Transaction> findAllByTimestampBetween(LocalDateTime start, LocalDateTime end);
}
