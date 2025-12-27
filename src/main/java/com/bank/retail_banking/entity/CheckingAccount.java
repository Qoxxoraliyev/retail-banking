package com.bank.retail_banking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "checking_accounts")
public class CheckingAccount{

    @Column(name = "overdraft_limit", nullable = false,precision = 19,scale = 2)
    @PositiveOrZero
    private BigDecimal overdraftLimit=BigDecimal.ZERO;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id",nullable = false,unique = true)
    @MapsId
    private Account account;

}
