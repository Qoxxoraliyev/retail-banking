package com.bank.retail_banking.entity;

import com.bank.retail_banking.enums.LoanStatus;
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
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,precision = 19,scale = 2)
    private BigDecimal principal;

    @Column(nullable = false,precision = 5,scale = 2)
    private BigDecimal interestRate;

    @Column(nullable = false)
    private Integer termInMonth;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 20)
    private LoanStatus status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "account_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_loan_account")
    )
    private Account account;
}
