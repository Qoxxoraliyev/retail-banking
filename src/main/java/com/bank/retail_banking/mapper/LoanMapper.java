package com.bank.retail_banking.mapper;

import com.bank.retail_banking.dto.LoanRequestDTO;
import com.bank.retail_banking.entity.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LoanMapper{

    @Mapping(source = "accountId",target = "account.id")
    Loan toEntity(LoanRequestDTO dto);

    @Mapping(source = "account.id",target = "accountId")
    LoanRequestDTO toResponseDTO(Loan loan);


}