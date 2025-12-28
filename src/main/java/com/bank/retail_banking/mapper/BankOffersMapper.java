package com.bank.retail_banking.mapper;

import com.bank.retail_banking.dto.BankOfferDTO;
import com.bank.retail_banking.dto.BankOffersRequestDTO;
import com.bank.retail_banking.dto.BankOffersResponseDTO;
import com.bank.retail_banking.entity.BankOffers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BankOffersMapper {

    @Mapping(source = "bankId",target = "bank.id")
    BankOffers toEntity(BankOffersRequestDTO dto);

    @Mapping(source = "bank.id",target = "bankId")
    BankOffersResponseDTO toResponseDTO(BankOffers entity);

    BankOfferDTO toBankOfferDTO(BankOffers bankOffers);
}
