package com.liteBank.service;

import com.liteBank.dtos.request.DepositRequest;
import com.liteBank.dtos.response.DepositResponse;

public interface AccountService {

    DepositResponse deposit(DepositRequest depositRequest);
}
