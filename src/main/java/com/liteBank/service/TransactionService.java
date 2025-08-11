package com.liteBank.service;

import com.liteBank.dtos.request.CreateTransactionRequest;
import com.liteBank.dtos.response.CreateTransactionResponse;

public interface TransactionService {

    CreateTransactionResponse create(CreateTransactionRequest request);
}