package com.bank.retail_banking.mapper;

import com.bank.retail_banking.dto.RewardRequestDTO;
import com.bank.retail_banking.dto.RewardResponseDTO;
import com.bank.retail_banking.entity.*;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface RewardMapper {

    default Rewards toEntity(RewardRequestDTO dto) {
        if (dto == null) return null;

        Rewards r = new Rewards();
        r.setRewardType(dto.rewardType());
        r.setAmount(dto.amount());

        Transaction t = new Transaction();
        t.setId(dto.transactionId());
        r.setTransaction(t);

        CreditCard c = new CreditCard();
        c.setId(dto.creditCardId());
        r.setCreditCard(c);

        User u = new User();
        u.setId(dto.userId());
        r.setUser(u);

        BankShoppingEnterprises e = new BankShoppingEnterprises();
        e.setId(dto.enterpriseId());
        r.setEnterprise(e);

        return r;
    }

    default RewardResponseDTO toResponseDTO(Rewards r) {
        if (r == null) return null;
        return new RewardResponseDTO(
                r.getId(),
                r.getRewardType(),
                r.getAmount(),
                r.getTransaction().getId(),
                r.getCreditCard().getId(),
                r.getUser().getId(),
                r.getEnterprise().getId()
        );
    }
}
