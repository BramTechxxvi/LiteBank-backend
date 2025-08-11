package com.liteBank.service;

import com.liteBank.data.repository.AccountRepository;
import com.liteBank.dtos.request.DepositRequest;
import com.liteBank.dtos.response.DepositResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public DepositResponse deposit(DepositRequest depositRequest) {
        accountRepository.find
        return null;
    }
}
