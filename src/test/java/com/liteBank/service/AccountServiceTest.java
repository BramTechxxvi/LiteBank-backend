package com.liteBank.service;

import com.liteBank.dtos.request.DepositRequest;
import com.liteBank.dtos.enums.PaymentMethod;
import com.liteBank.dtos.response.DepositResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    void testCanDeposit() {
        DepositRequest depositRequest = new DepositRequest();
        depositRequest.setSenderAccountNumber("0701234567");
        depositRequest.setRecipientAccountNumber("0801234567");
        depositRequest.setPaymentMethod(PaymentMethod.CARD);
        depositRequest.setAmount(new BigDecimal("10000.00"));

        DepositResponse depositResponse = accountService.deposit(depositRequest);
        assertNotNull(depositResponse.getTransactionId());
    }
}
