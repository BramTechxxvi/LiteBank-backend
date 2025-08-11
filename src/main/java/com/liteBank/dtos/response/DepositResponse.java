package com.liteBank.dtos.response;

import com.liteBank.dtos.enums.TransactionStatus;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class DepositResponse {

    private TransactionStatus transactionStatus;
    private String transactionId;
    private BigDecimal amount;
}