package com.liteBank.service;

import com.liteBank.dtos.request.DepositRequest;
import com.liteBank.dtos.response.DepositResponse;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public DepositResponse deposit(DepositRequest depositRequest) {
        accountRepository.save()
        return null;
    }
}
