package com.bank.retail_banking.mapper;

import com.bank.retail_banking.dto.FDDTO;
import com.bank.retail_banking.entity.FD;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FDMapper {

    @Mapping(source = "accountId",target = "account.id")
    FD toEntity(FDDTO fddto);

    @Mapping(source = "account.id",target = "accountId")
    FDDTO toDTO(FD fd);

}
