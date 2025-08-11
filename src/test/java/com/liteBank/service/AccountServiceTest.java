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
        depositRequest.setAccountNumber("0701234567");
        depositRequest.setPaymentMethod(PaymentMethod.CARD);
        depositRequest.setAmount(new BigDecimal(10_000));

        DepositResponse depositResponse = accountService.deposit(depositRequest);
        assertNotNull(depositResponse.getTransactionId());
    }
}
