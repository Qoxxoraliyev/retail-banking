package com.bank.retail_banking.entity;

import jakarta.persistence.*;
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
@Table(name = "savings_account")
public class SavingsAccount{

    @Column(name ="interest_rate",precision = 5,scale = 2)
    private BigDecimal interestRate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false,unique = true)
    private Account account;

}
