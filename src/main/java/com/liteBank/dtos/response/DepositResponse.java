package com.liteBank.dtos.response;

import com.liteBank.dtos.enums.TransactionStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DepositResponse {

    private TransactionStatus transactionStatus;
}
