package com.liteBank.service;

import com.liteBank.dtos.request.DepositRequest;
import com.liteBank.dtos.PaymentMethod;
import com.liteBank.dtos.response.DepositResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class AccountServiceTest {

    @Test
    void testCanDeposit() {
        DepositRequest depositRequest = new DepositRequest(
                "0801234567",
                "0701234567",
                new BigDecimal(10_000),
                PaymentMethod.CARD);
    }
    DepositResponse depositResponse = accountService.deposit(depositRequest);

}
