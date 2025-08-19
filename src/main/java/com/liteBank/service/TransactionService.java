package com.liteBank.service;

import com.liteBank.dtos.request.CreateTransactionRequest;
import com.liteBank.dtos.response.CreateTransactionResponse;
import com.liteBank.dtos.response.TransactionResponse;

public interface TransactionService {

    CreateTransactionResponse create(CreateTransactionRequest request);
    TransactionResponse getTransactionBy(String id);

}