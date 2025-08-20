package com.liteBank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liteBank.dtos.enums.PaymentMethod;
import com.liteBank.dtos.request.DepositRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCanDeposit() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        DepositRequest depositRequest = new DepositRequest();
        depositRequest.setAccountNumber("0123456789");
        depositRequest.setAmount(new BigDecimal("200_000.00"));
        depositRequest.setPaymentMethod(PaymentMethod.CARD);
        String json = mapper.writeValueAsString(depositRequest);
        String depositEndpoint = "api/vi/account";
        mockMvc.perform(MockMvcRequestBuilders.post(depositEndpoint)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

    }
}
