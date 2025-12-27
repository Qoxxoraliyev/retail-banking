package com.bank.retail_banking.mapper;

import com.bank.retail_banking.dto.TransactionDTO;
import com.bank.retail_banking.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    @Mapping(source = "fromAccountId", target = "fromAccount.id")
    @Mapping(source = "toAccountId", target = "toAccount.id")
    @Mapping(source = "accountId", target = "account.id")
    Transaction toTransaction(TransactionDTO dto);


    @Mapping(source = "fromAccount.id", target = "fromAccountId")
    @Mapping(source = "toAccount.id", target = "toAccountId")
    @Mapping(source = "account.id", target = "accountId")
    TransactionDTO toDTO(Transaction transaction);
}
