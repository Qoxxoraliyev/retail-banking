package com.bank.retail_banking.mapper;

import com.bank.retail_banking.dto.AccountRequestDTO;
import com.bank.retail_banking.dto.AccountResponseDTO;
import com.bank.retail_banking.entity.Account;
import com.bank.retail_banking.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(source = "userId", target = "user")
    Account toAccount(AccountRequestDTO dto);

    AccountResponseDTO toAccountResponseDTO(Account account);

    default User map(Long userId) {
        if (userId == null) return null;
        User user = new User();
        user.setId(userId);
        return user;
    }
}

