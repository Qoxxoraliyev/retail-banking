package com.bank.retail_banking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@DiscriminatorValue("SAVINGS")
@Table(name = "savings_account")
public class SavingsAccount extends Account{

    @Column(name ="interest_rate",precision = 5,scale = 2)
    private BigDecimal interestRate;

}
