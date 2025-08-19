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

import static com.liteBank.util.ProjectUtil.DEFAULT_PAGE_NUMBER;
import static com.liteBank.util.ProjectUtil.DEFAULT_PAGE_SIZE;

@Service
@AllArgsConstructor
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    @Override
    public CreateTransactionResponse create(CreateTransactionRequest createRequest) {
        Transaction transaction = transactionRepository.save(buildTransactionFrom(createRequest));
        return buildTransactionResponse(transaction);
    }

    private CreateTransactionResponse buildTransactionResponse(Transaction transaction) {
//        CreateTransactionResponse response = new CreateTransactionResponse();
//        response.setId(transaction.getId());
//        response.setAmount(transaction.getAmount().toString());
//        response.setTransactionType(transaction.getTransactionType().toString()
        return modelMapper.map(transaction, CreateTransactionResponse.class);
    }

    private Transaction buildTransactionFrom(CreateTransactionRequest request) {
//        Transaction transaction = new Transaction();
//        transaction.setAmount(request.getAmount());
//        transaction.setTransactionType(request.getTransactionType());
//        transaction.setAccountNumber(request.getAccountNumber());
        return modelMapper.map(request, Transaction.class);
    }

    @Override
    public TransactionResponse getTransactionById(String id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
/*
        TransactionResponse response = new TransactionResponse();
        response.setAmount(transaction.getAmount().toString());
*/

        return modelMapper.map(transaction, TransactionResponse.class);
    }

    @Override
    public List<TransactionResponse> getTransactionsFor(String accountNumber) {
        List<Transaction> transactions =
                transactionRepository.findTransactionByAccountNumber(accountNumber);
        Type listType = new TypeToken<List<TransactionResponse>>() {

        }.getType();
//        List<TransactionResponse> transactionResponses =
//                modelMapper.map(transactions.getContent(), listType);
//        log.info("Retrieved :: {}", transactionResponses);

        return  modelMapper.map(transactions, listType);
//        return transactionResponses;
    }
}