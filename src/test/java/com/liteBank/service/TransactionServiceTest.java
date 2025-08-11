package com.liteBank.service;

import com.liteBank.dtos.enums.TransactionType;
import com.liteBank.dtos.request.CreateTransactionRequest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class TransactionServiceTest {

    @Test
    void testCanCreateTransaction() {
        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setTransactionType(TransactionType.CREDIT);
        createTransactionRequest.setAccountNumber("0123456789");
        createTransactionRequest.setAmount(new BigDecimal(20_000));
    }
}
