package com.liteBank.service;

import com.liteBank.dtos.enums.TransactionType;
import com.liteBank.dtos.request.CreateTransactionRequest;
import com.liteBank.dtos.response.CreateTransactionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @Test
    void testCanCreateTransaction() {
        CreateTransactionRequest transactionRequest = new CreateTransactionRequest();
        transactionRequest.setTransactionType(TransactionType.CREDIT);
        transactionRequest.setAccountNumber("0123456789");
        transactionRequest.setAmount(new BigDecimal(20_000));

        CreateTransactionResponse transactionResponse = transactionService.create(transactionRequest);
    }
}
