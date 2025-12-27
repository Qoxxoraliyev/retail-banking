package com.bank.retail_banking.mapper;

import com.bank.retail_banking.dto.CheckingAccountDTO;
import com.bank.retail_banking.entity.CheckingAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CheckingAccountMapper {

    CheckingAccountMapper INSTANCE= Mappers.getMapper(CheckingAccountMapper.class);

    @Mapping(source = "accountId",target = "account.id")
    CheckingAccount toEntity(CheckingAccountDTO dto);

    @Mapping(source = "account.id",target = "accountId")
    CheckingAccountDTO toDTO(CheckingAccount checkingAccount);
}
