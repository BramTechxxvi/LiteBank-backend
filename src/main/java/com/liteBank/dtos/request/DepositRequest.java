package com.liteBank.dtos.request;

import com.liteBank.dtos.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class DepositRequest {

    private String accountNumber;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
}