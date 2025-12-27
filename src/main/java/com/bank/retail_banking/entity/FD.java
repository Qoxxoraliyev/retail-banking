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
@Table(name = "fd")
public class FD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "min_balance",nullable = false,precision = 19,scale = 2)
    @PositiveOrZero
    private BigDecimal minBalance;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false,unique = true)
    private Account account;


}
