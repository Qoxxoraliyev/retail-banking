package com.bank.retail_banking.entity;

import com.bank.retail_banking.enums.EnterpriseName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bank_shopping_enterprises")
public class BankShoppingEnterprises {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private EnterpriseName enterpriseName;

    @Column(length = 500)
    private String enterpriseDescription;

    @OneToMany(mappedBy = "enterprise",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Rewards> rewards;

    @ManyToOne
    @JoinColumn(name = "parent_enterprise_id")
    private BankShoppingEnterprises parentEnterprise;


}
