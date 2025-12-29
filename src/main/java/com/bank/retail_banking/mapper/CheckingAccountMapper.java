package com.bank.retail_banking.mapper;

import com.bank.retail_banking.dto.CheckingAccountDTO;
import com.bank.retail_banking.entity.Account;
import com.bank.retail_banking.entity.CheckingAccount;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface CheckingAccountMapper {

    default CheckingAccount toEntity(CheckingAccountDTO dto) {
        if (dto == null) return null;

        CheckingAccount ca = new CheckingAccount();
        ca.setId(dto.id());
        ca.setOverdraftLimit(dto.overdraftLimit());

        if (dto.accountId() != null) {
            Account account = new Account();
            account.setId(dto.accountId());
            ca.setAccount(account);
        }

        return ca;
    }

    default CheckingAccountDTO toDTO(CheckingAccount ca) {
        if (ca == null) return null;

        return new CheckingAccountDTO(
                ca.getId(),
                ca.getOverdraftLimit(),
                ca.getAccount() != null ? ca.getAccount().getId() : null
        );
    }
}
