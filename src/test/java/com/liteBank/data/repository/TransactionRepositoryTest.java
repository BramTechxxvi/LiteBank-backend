package com.liteBank.data.repository;

import com.liteBank.data.models.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    void retrieveAccountNumberTest() {
        String accountNumber = "0123456789";
        Pageable pageable = PageRequest.of(0, 5);
        Page<Transaction> transactions = transactionRepository.retrieveByAccountNumber(accountNumber, pageable);
        assertThat(transactions).isNotNull();
        assertThat(transactions.getContent().size().isEqualto(5));
    }

}