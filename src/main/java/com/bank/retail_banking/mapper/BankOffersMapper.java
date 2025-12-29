package com.bank.retail_banking.mapper;

import com.bank.retail_banking.dto.BankOfferDTO;
import com.bank.retail_banking.dto.BankOffersRequestDTO;
import com.bank.retail_banking.dto.BankOffersResponseDTO;
import com.bank.retail_banking.entity.Bank;
import com.bank.retail_banking.entity.BankOffers;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BankOffersMapper {

    BankOffersMapper INSTANCE = Mappers.getMapper(BankOffersMapper.class);

    @Mapping(source = "bankId", target = "bank.id")
    BankOffers toEntity(BankOffersRequestDTO dto);

    @AfterMapping
    default void setBank(
            BankOffersRequestDTO dto,
            @MappingTarget BankOffers entity
    ) {
        Bank bank = new Bank();
        bank.setId(dto.bankId());
        entity.setBank(bank);
    }
    @Mapping(source = "bank.id", target = "bankId")
    BankOffersResponseDTO toResponseDTO(BankOffers entity);
    BankOfferDTO toBankOfferDTO(BankOffers entity);
}
