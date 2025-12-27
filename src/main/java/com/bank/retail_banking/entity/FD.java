package com.bank.retail_banking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@DiscriminatorValue("FD")
@Table(name = "fd")
public class FD extends Account{

    @Column(name = "min_balance",nullable = false,precision = 19,scale = 2)
    @PositiveOrZero
    private BigDecimal minBalance;


}
