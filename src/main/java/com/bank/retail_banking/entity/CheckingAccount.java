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
@DiscriminatorValue("CHECKING")
@Table(name = "checking_accounts")
public class CheckingAccount extends Account {

    @Column(name = "overdraft_limit", nullable = false,precision = 19,scale = 2)
    private BigDecimal overdraftLimit;


}
