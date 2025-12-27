package com.bank.retail_banking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




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

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "bank_id",nullable = false)
    private Bank bank;


}
