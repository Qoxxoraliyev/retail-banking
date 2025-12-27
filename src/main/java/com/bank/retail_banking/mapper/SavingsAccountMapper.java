package com.bank.retail_banking.mapper;

import com.bank.retail_banking.dto.SavingsAccountDTO;
import com.bank.retail_banking.entity.SavingsAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SavingsAccountMapper {

    SavingsAccountMapper INSTANCE= Mappers.getMapper(SavingsAccountMapper.class);

    @Mapping(source = "accountId",target = "account.id")
    SavingsAccount toEntity(SavingsAccountDTO dto);

    @Mapping(source = "account.id",target = "accountId")
    SavingsAccountDTO toDTO(SavingsAccount savingsAccount);

}
