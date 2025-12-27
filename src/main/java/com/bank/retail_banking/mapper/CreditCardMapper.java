package com.bank.retail_banking.mapper;

import com.bank.retail_banking.dto.CreditCardDTO;
import com.bank.retail_banking.entity.CreditCard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CreditCardMapper {

    @Mapping(source = "accountId", target = "account.id")
    CreditCard toEntity(CreditCardDTO dto);


    @Mapping(source = "account.id", target = "accountId")
    CreditCardDTO toDTO(CreditCard creditCard);
}
