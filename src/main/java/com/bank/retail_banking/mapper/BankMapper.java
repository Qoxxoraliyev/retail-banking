package com.bank.retail_banking.mapper;

import com.bank.retail_banking.dto.BankDTO;
import com.bank.retail_banking.dto.BankRequestDTO;
import com.bank.retail_banking.dto.BankResponseDTO;
import com.bank.retail_banking.entity.Bank;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BankMapper {

    BankMapper INSTANCE= Mappers.getMapper(BankMapper.class);

    Bank toEntity(BankRequestDTO dto);

    BankResponseDTO toDTO(Bank bank);

    BankDTO toBankDTO(Bank bank);


}
