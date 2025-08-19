package com.liteBank.service;

import com.liteBank.data.models.Transaction;
import com.liteBank.data.repository.TransactionRepository;
import com.liteBank.dtos.request.CreateTransactionRequest;
import com.liteBank.dtos.response.CreateTransactionResponse;
import com.liteBank.dtos.response.TransactionResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;
    private ModelMapper modelMapper;

    @Override
    public CreateTransactionResponse create(CreateTransactionRequest createRequest) {
        Transaction transaction = transactionRepository.save(buildTransactionFrom(createRequest));

        return buildTransactionResponse(transaction);
    }

    private static CreateTransactionResponse buildTransactionResponse(Transaction transaction) {
        CreateTransactionResponse response = new CreateTransactionResponse();
        response.setId(transaction.getId());
        response.setAmount(transaction.getAmount().toString());
        response.setTransactionType(transaction.getTransactionType().toString());
        return response;
    }

    private static Transaction buildTransactionFrom(CreateTransactionRequest request) {
        Transaction transaction = new Transaction();
        transaction.setAmount(request.getAmount());
        transaction.setTransactionType(request.getTransactionType());
        transaction.setAccountNumber(request.getAccountNumber());
        return transaction;
    }

    @Override
    public TransactionResponse getTransactionBy(String id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        TransactionResponse response = new TransactionResponse();
        response.setAmount(transaction.getAmount().toString());

        return response;
    }

    @Override
    public List<TransactionResponse> getTransactionsFor(String accountNumber, int page, int size) {
        page = page -1 ;
        Pageable pageable = PageRequest.of(page, size);
        Page<Transaction> transactions =
                transactionRepository.retrieveTransactionByAccountNumber(accountNumber, pageable);
        Type listType = new TypeToken<List<TransactionResponse>>() {}.getType();
        List<TransactionResponse> transactionResponses =
                modelMapper.map(transactions.getContent(), listType);
        log.info("Retrieved :: {}", transactionResponses);

        return transactionResponses;
    }
}