package com.bank.retail_banking.mapper;

import com.bank.retail_banking.dto.BankShoppingEnterpriseRequestDTO;
import com.bank.retail_banking.dto.BankShoppingEnterpriseResponseDTO;
import com.bank.retail_banking.entity.BankShoppingEnterprises;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface BankShoppingEnterpriseMapper {

    default BankShoppingEnterprises toEntity(BankShoppingEnterpriseRequestDTO dto) {
        if (dto == null) return null;

        BankShoppingEnterprises entity = new BankShoppingEnterprises();
        entity.setEnterpriseName(dto.enterpriseName());
        entity.setEnterpriseDescription(dto.enterpriseDescription());

        if (dto.parentEnterpriseId() != null) {
            BankShoppingEnterprises parent = new BankShoppingEnterprises();
            parent.setId(dto.parentEnterpriseId());
            entity.setParentEnterprise(parent);
        }

        return entity;
    }

    default BankShoppingEnterpriseResponseDTO toDTO(BankShoppingEnterprises entity) {
        if (entity == null) return null;

        return new BankShoppingEnterpriseResponseDTO(
                entity.getId(),
                entity.getEnterpriseName(),
                entity.getEnterpriseDescription(),
                entity.getParentEnterprise() != null ? entity.getParentEnterprise().getId() : null
        );
    }
}
