package com.liteBank.service;

import com.liteBank.dtos.request.CreateTransactionRequest;
import com.liteBank.dtos.response.CreateTransactionResponse;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Override
    public CreateTransactionResponse create(CreateTransactionRequest request) {
        return null;
    }
}
