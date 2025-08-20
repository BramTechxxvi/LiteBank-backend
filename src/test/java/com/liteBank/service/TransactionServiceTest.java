package com.liteBank.service;

import com.liteBank.dtos.enums.TransactionType;
import com.liteBank.dtos.request.CreateTransactionRequest;
import com.liteBank.dtos.response.CreateTransactionResponse;
import com.liteBank.dtos.response.TransactionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = {"/db/data.sql"})
public class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @Test
    void testCanCreateTransaction() {
        CreateTransactionRequest transactionRequest = new CreateTransactionRequest();
        transactionRequest.setTransactionType(TransactionType.CREDIT);
        transactionRequest.setAccountNumber("0123456789");
        transactionRequest.setAmount(new BigDecimal("20000.00"));

        CreateTransactionResponse transactionResponse = transactionService.create(transactionRequest);
        assertNotNull(transactionResponse);
        TransactionResponse transaction =
                transactionService.getTransactionById(transactionResponse.getId());
        assertThat(transaction).isNotNull();
        assertThat(transaction.getAmount())
                .isEqualTo(transactionRequest.getAmount().toString());
    }

    @Test
    void testCanGetTransactionByAccountNumber() {
        List<TransactionResponse> transactions =
                transactionService.getTransactionsFor("0123456789");
        assertThat(transactions).isNotNull();
        assertThat(transactions.size()).isEqualTo(5);
    }
}