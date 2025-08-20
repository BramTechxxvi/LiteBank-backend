package com.liteBank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liteBank.dtos.response.TransactionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static java.nio.file.Paths.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
@Sql(scripts = {"/db/data.sql"})
public class TransactionControllerTest {

    private MockMvc mockMvc;

    @Test
    void testCanGetTransactionForAccount() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String accountNumber = "0123456789";
        String getTransactionsEndpoint = "api/v1/transactions";
        String json = mapper.writeValueAsString(getTransactionsEndpoint);

        mockMvc.perform(MockMvcRequestBuilders.get(getTransactionsEndpoint)
                        .param("accountNumber", "0123456789")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }

}
