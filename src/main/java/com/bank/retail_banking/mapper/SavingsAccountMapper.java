package com.bank.retail_banking.mapper;

import com.bank.retail_banking.dto.SavingsAccountDTO;
import com.bank.retail_banking.entity.Account;
import com.bank.retail_banking.entity.SavingsAccount;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface SavingsAccountMapper {

    default SavingsAccount toEntity(SavingsAccountDTO dto) {
        if (dto == null) return null;

        SavingsAccount sa = new SavingsAccount();
        sa.setId(dto.id());
        sa.setInterestRate(dto.interestRate());

        if (dto.accountId() != null) {
            Account account = new Account();
            account.setId(dto.accountId());
            sa.setAccount(account);
        }

        return sa;
    }

    default SavingsAccountDTO toDTO(SavingsAccount sa) {
        if (sa == null) return null;

        return new SavingsAccountDTO(
                sa.getId(),
                sa.getInterestRate(),
                sa.getAccount() != null ? sa.getAccount().getId() : null
        );
    }
}

