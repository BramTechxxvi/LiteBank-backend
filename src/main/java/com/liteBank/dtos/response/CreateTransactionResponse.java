package com.liteBank.dtos.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class CreateTransactionResponse {
    private String id;
    private String transactionType;
    private String amount;
}