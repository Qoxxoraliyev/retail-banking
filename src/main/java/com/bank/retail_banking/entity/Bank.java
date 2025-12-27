package com.bank.retail_banking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "banks")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,precision = 15,scale = 2)
    private Double balance;

    @OneToMany(mappedBy = "bank",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<BankOffers> bankOffers=new ArrayList<>();

    @OneToMany(mappedBy = "bank",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<User> users=new ArrayList<>();

}
