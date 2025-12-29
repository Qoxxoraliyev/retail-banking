package com.bank.retail_banking.mapper;

import com.bank.retail_banking.dto.LoanRequestDTO;
import com.bank.retail_banking.entity.Account;
import com.bank.retail_banking.entity.Loan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoanMapper {

    default Loan toEntity(LoanRequestDTO dto) {
        if (dto == null) return null;

        Loan loan = new Loan();
        loan.setPrincipal(dto.principal());
        loan.setInterestRate(dto.interestRate());
        loan.setTermInMonth(dto.termInMonth());

        if (dto.accountId() != null) {
            Account account = new Account();
            account.setId(dto.accountId());
            loan.setAccount(account);
        }

        return loan;
    }

    default LoanRequestDTO toResponseDTO(Loan loan) {
        if (loan == null) return null;

        return new LoanRequestDTO(
                loan.getPrincipal(),
                loan.getInterestRate(),
                loan.getTermInMonth(),
                loan.getAccount() != null ? loan.getAccount().getId() : null
        );
    }
}
