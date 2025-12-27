package com.bank.retail_banking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public  class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number",nullable = false,unique = true)
    private String accountNumber;

    @Column(nullable = false, precision = 19, scale = 2)
    @PositiveOrZero
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @OneToOne(mappedBy = "account",cascade = CascadeType.ALL,orphanRemoval = true)
    private CheckingAccount checkingAccount;

    @OneToOne(mappedBy = "account",cascade = CascadeType.ALL,orphanRemoval = true)
    private AccountVerification accountVerification;

    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Transaction> transactions=new ArrayList<>();

    @OneToOne(mappedBy = "account",cascade = CascadeType.ALL,orphanRemoval = true)
    private CreditCard card;
}
