package com.liteBank.service;

import com.liteBank.data.models.Transaction;
import com.liteBank.data.repository.TransactionRepository;
import com.liteBank.dtos.request.CreateTransactionRequest;
import com.liteBank.dtos.response.CreateTransactionResponse;
import com.liteBank.dtos.response.TransactionResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    @Override
    public CreateTransactionResponse create(CreateTransactionRequest request) {
        Transaction transaction = new Transaction();
        transaction.setAmount(request.getAmount());
        transaction.setTransactionType(request.getTransactionType());
        transaction.setAccountNumber(request.getAccountNumber());
        transaction = transactionRepository.save(transaction);

        CreateTransactionResponse response = new CreateTransactionResponse();
        response.setId(transaction.getId());
        response.setAmount(transaction.getAmount().toString());
        response.setTransactionType(transaction.getTransactionType().toString());

        return response;
    }

    @Override
    public TransactionResponse getTransactionBy(String id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        return null;
    }
}