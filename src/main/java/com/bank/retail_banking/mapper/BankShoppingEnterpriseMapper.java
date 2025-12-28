package com.bank.retail_banking.mapper;

import com.bank.retail_banking.dto.BankShoppingEnterpriseRequestDTO;
import com.bank.retail_banking.dto.BankShoppingEnterpriseResponseDTO;
import com.bank.retail_banking.entity.BankShoppingEnterprises;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BankShoppingEnterpriseMapper {

    BankShoppingEnterpriseMapper INSTANCE= Mappers.getMapper(BankShoppingEnterpriseMapper.class);

    @Mapping(target = "parentEnterprise.id", source = "parentEnterpriseId")
    BankShoppingEnterprises toEntity(BankShoppingEnterpriseRequestDTO dto);

    @Mapping(target = "parentEnterpriseId", source = "parentEnterprise.id")
    BankShoppingEnterpriseResponseDTO toDTO(BankShoppingEnterprises entity);

}
