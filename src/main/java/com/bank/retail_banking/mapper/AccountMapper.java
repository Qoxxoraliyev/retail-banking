package com.bank.retail_banking.mapper;

import com.bank.retail_banking.dto.AccountRequestDTO;
import com.bank.retail_banking.dto.AccountResponseDTO;
import com.bank.retail_banking.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE=Mappers.getMapper(AccountMapper.class);

    @Mapping(source = "userId",target = "user.id")
    Account toAccount(AccountRequestDTO dto);

    AccountResponseDTO toAccountResponseDTO(Account account);
}
