package com.liteBank.service;

import com.liteBank.dtos.enums.TransactionStatus;
import com.liteBank.dtos.request.DepositRequest;
import com.liteBank.dtos.enums.PaymentMethod;
import com.liteBank.dtos.response.DepositResponse;
import com.liteBank.dtos.response.ViewAccountResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = {"/db/data.sql"})
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    void testCanDeposit() {
        DepositRequest depositRequest = new DepositRequest();
        depositRequest.setAccountNumber("0123456789");
        depositRequest.setPaymentMethod(PaymentMethod.CARD);
        depositRequest.setAmount(new BigDecimal(10_000));

        DepositResponse depositResponse = accountService.deposit(depositRequest);
        assertNotNull(depositResponse);
        assertEquals(TransactionStatus.SUCCESS, depositResponse.getTransactionStatus());
    }

    @Test
    void testCanViewAccount() {
        ViewAccountResponse response = accountService.viewDetailsFor("0123456789");
        assertThat(response).isNotNull();
        assertThat(response.getBalance()).isEqualTo(("10000.00"));

//-71800
    }
}
