package com.bank.retail_banking.mapper;

import com.bank.retail_banking.dto.UserDTO;
import com.bank.retail_banking.dto.UserRequestDTO;
import com.bank.retail_banking.dto.UserResponseDTO;
import com.bank.retail_banking.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

    @Mapping(source = "bankId",target = "bank.id")
    User toEntity(UserRequestDTO dto);

    @Mapping(source = "bank",target = "bank")
    UserResponseDTO toDTO(User user);

    UserDTO toUserDTO(User user);

}
