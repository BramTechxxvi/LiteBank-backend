package com.liteBank.service;

import com.liteBank.data.models.Account;
import com.liteBank.data.repository.AccountRepository;
import com.liteBank.dtos.enums.TransactionStatus;
import com.liteBank.dtos.enums.TransactionType;
import com.liteBank.dtos.request.CreateTransactionRequest;
import com.liteBank.dtos.request.DepositRequest;
import com.liteBank.dtos.response.DepositResponse;
import com.liteBank.exception.AccountNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final TransactionService transactionService;

    @Override
    public DepositResponse deposit(DepositRequest depositRequest) {
        Account foundAccount = accountRepository.findByAccountNumber(depositRequest.getAccountNumber())
                .orElseThrow(()-> new AccountNotFoundException("Account not found"));
        // Creating transaction record to use
        CreateTransactionRequest transactionRequest = new CreateTransactionRequest();
        transactionRequest.setAmount(depositRequest.getAmount());
        transactionRequest.setAccountNumber(depositRequest.getAccountNumber());
        transactionRequest.setTransactionType(TransactionType.CREDIT);
        var transactionResponse = transactionService.create(transactionRequest);

        DepositResponse depositResponse = new DepositResponse();
        depositResponse.setAmount(new BigDecimal(transactionResponse.getAmount()));
        depositResponse.setTransactionId(transactionResponse.getId());
        depositResponse.setTransactionStatus(TransactionStatus.SUCCESS);

        return depositResponse;
    }
}