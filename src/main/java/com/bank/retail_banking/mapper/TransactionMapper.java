package com.bank.retail_banking.mapper;
import com.bank.retail_banking.dto.TransactionDTO;
import com.bank.retail_banking.entity.Account;
import com.bank.retail_banking.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    default Transaction toTransaction(TransactionDTO dto) {
        if (dto == null) return null;

        Transaction transaction = new Transaction();
        transaction.setId(dto.id());
        transaction.setTransactionId(dto.transactionId());
        transaction.setType(dto.type());
        transaction.setAmount(dto.amount());
        transaction.setTimestamp(dto.timestamp());

        if (dto.fromAccountId() != null) {
            Account from = new Account();
            from.setId(dto.fromAccountId());
            transaction.setFromAccount(from);
        }

        if (dto.toAccountId() != null) {
            Account to = new Account();
            to.setId(dto.toAccountId());
            transaction.setToAccount(to);
        }

        if (dto.accountId() != null) {
            Account acc = new Account();
            acc.setId(dto.accountId());
            transaction.setAccount(acc);
        }

        return transaction;
    }

    default TransactionDTO toDTO(Transaction transaction) {
        if (transaction == null) return null;

        return new TransactionDTO(
                transaction.getId(),
                transaction.getTransactionId(),
                transaction.getType(),
                transaction.getAmount(),
                transaction.getTimestamp(),
                transaction.getToAccount() != null ? transaction.getToAccount().getId() : null,
                transaction.getFromAccount() != null ? transaction.getFromAccount().getId() : null,
                transaction.getAccount() != null ? transaction.getAccount().getId() : null
        );
    }
}
