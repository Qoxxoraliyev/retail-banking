package com.bank.retail_banking.mapper;

import com.bank.retail_banking.dto.BankDTO;
import com.bank.retail_banking.dto.BankRequestDTO;
import com.bank.retail_banking.dto.BankResponseDTO;
import com.bank.retail_banking.entity.Bank;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface BankMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "bankOffers", ignore = true)
    @Mapping(target = "users", ignore = true)
    Bank toEntity(BankRequestDTO dto);

    BankResponseDTO toResponseDTO(Bank bank);

    BankDTO toBankDTO(Bank bank);
}

