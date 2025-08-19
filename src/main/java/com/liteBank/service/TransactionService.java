package com.liteBank.service;

import com.liteBank.dtos.request.CreateTransactionRequest;
import com.liteBank.dtos.response.CreateTransactionResponse;
import com.liteBank.dtos.response.TransactionResponse;

import java.util.List;

public interface TransactionService {

    CreateTransactionResponse create(CreateTransactionRequest request);
    TransactionResponse getTransactionById(String id);
    List<TransactionResponse> getTransactionsFor(String accountNumber, int pageable, int size);

}