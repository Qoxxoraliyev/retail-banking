package com.bank.retail_banking.entity;

import com.bank.retail_banking.enums.OfferType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bank_offers")
public class BankOffers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;

    @Column(name = "offer_name",nullable = false,length = 100)
    private String offerName;

    @Column(name = "offer_description",columnDefinition = "TEXT")
    private String offerDescription;

    @Enumerated(EnumType.STRING)
    private OfferType offerType;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal value;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal budget;

    private LocalDate startDate;

    private LocalDate endDate;

    private boolean active;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "bank_id",nullable = false)
    private Bank bank;

    @ManyToMany
    @JoinTable(
            name = "offer_credit_card",
            joinColumns = @JoinColumn(name = "offer_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id")
    )
    private List<CreditCard> creditCards = new ArrayList<>();



}
