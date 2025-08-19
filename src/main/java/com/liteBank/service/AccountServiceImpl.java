package com.liteBank.service;

import com.liteBank.data.repository.AccountRepository;
import com.liteBank.dtos.enums.TransactionStatus;
import com.liteBank.dtos.enums.TransactionType;
import com.liteBank.dtos.request.CreateTransactionRequest;
import com.liteBank.dtos.request.DepositRequest;
import com.liteBank.dtos.response.CreateTransactionResponse;
import com.liteBank.dtos.response.DepositResponse;
import com.liteBank.dtos.response.TransactionResponse;
import com.liteBank.dtos.response.ViewAccountResponse;
import com.liteBank.exception.AccountNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static java.math.BigDecimal.ZERO;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final TransactionService transactionService;

    @Override
    public DepositResponse deposit(DepositRequest depositRequest) {
        accountRepository.findByAccountNumber(depositRequest.getAccountNumber())
                .orElseThrow(()-> new AccountNotFoundException("Account not found"));

        CreateTransactionRequest transactionRequest = buildTransactionRequest(depositRequest);
        var transactionResponse = transactionService.create(transactionRequest);

        return buildDepositResponse(transactionResponse);
    }

    @Override
    public ViewAccountResponse viewDetailsFor(String accountNumber) {
        List<TransactionResponse> transactions =
                transactionService.getTransactionsFor(accountNumber);
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setAmount(ZERO.toString());
        TransactionResponse response = transactions.stream()
                .reduce(transactionResponse , (a, b)-> {
                    BigDecimal total = ZERO;
                    if (b.getTransactionType() == TransactionType.CREDIT)
                        total = total.add(new BigDecimal(b.getAmount()));

                })
        return null;
    }

    private static CreateTransactionRequest buildTransactionRequest(DepositRequest depositRequest) {
        var createTransactionRequest = new CreateTransactionRequest();
        createTransactionRequest.setAccountNumber(depositRequest.getAccountNumber());
        createTransactionRequest.setAmount(depositRequest.getAmount());
        createTransactionRequest.setTransactionType(TransactionType.CREDIT);

        return createTransactionRequest;
    }

    private static DepositResponse buildDepositResponse(CreateTransactionResponse response) {
        var depositResponse = new DepositResponse();
        depositResponse.setAmount(new BigDecimal(response.getAmount()));
        depositResponse.setTransactionId(response.getId());
        depositResponse.setTransactionStatus(TransactionStatus.SUCCESS);

        return depositResponse;
    }
}