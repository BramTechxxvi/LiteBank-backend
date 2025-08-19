package com.liteBank.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class CreateTransactionResponse {
    private String id;
    private String transactionType;
    private String amount;
}