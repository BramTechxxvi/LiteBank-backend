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
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static java.math.BigDecimal.ZERO;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final TransactionService transactionService;
    private final ModelMapper modelMapper;

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
                .reduce(transactionResponse, (a, b) -> {
                    BigDecimal total = ZERO;
                    if (b.getTransactionType() == TransactionType.CREDIT)
                        total = total.add(new BigDecimal(b.getAmount()));
                    else
                        total = total.subtract(new BigDecimal(b.getAmount()));
                    transactionResponse.setAmount(
                            new BigDecimal(a.getAmount())
                                    .add(total).toString()
                    );
                    return transactionResponse;
                });

        ViewAccountResponse viewAccountResponse = new ViewAccountResponse();
        viewAccountResponse.setBalance(response.toString());
        return viewAccountResponse;
    }

    private CreateTransactionRequest buildTransactionRequest(DepositRequest depositRequest) {
        return modelMapper.map(depositRequest, CreateTransactionRequest.class);
    }

    private DepositResponse buildDepositResponse(CreateTransactionResponse response) {
        return modelMapper.map(response, DepositResponse.class);
    }
}