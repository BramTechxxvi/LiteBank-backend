package com.liteBank.dtos.request;

import com.liteBank.dtos.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class CreateTransactionRequest {

    private TransactionType transactionType;
    private String accountNumber;
    private BigDecimal amount;
}