package com.bank.retail_banking.dto;

import com.bank.retail_banking.entity.Rewards;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RewardMapper {

    RewardMapper INSTANCE= Mappers.getMapper(RewardMapper.class);

    @Mapping(source = "transactionId", target = "transaction.id")
    @Mapping(source = "creditCardId", target = "creditCard.id")
    @Mapping(source = "userId", target = "user.id")
    Rewards toEntity(RewardRequestDTO dto);


    @Mapping(source = "transaction.id", target = "transactionId")
    @Mapping(source = "creditCard.id", target = "creditCardId")
    @Mapping(source = "user.id", target = "userId")
    RewardResponseDTO toResponseDTO(Rewards rewards);
}
