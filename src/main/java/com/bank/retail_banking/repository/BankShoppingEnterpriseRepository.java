package com.bank.retail_banking.repository;

import com.bank.retail_banking.entity.BankShoppingEnterprises;
import com.bank.retail_banking.enums.EnterpriseName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BankShoppingEnterpriseRepository extends JpaRepository<BankShoppingEnterprises,Long> {

    Optional<BankShoppingEnterprises> findByEnterpriseName(EnterpriseName name);

    List<BankShoppingEnterprises> findByParentEnterpriseId(Long parentId);


}
