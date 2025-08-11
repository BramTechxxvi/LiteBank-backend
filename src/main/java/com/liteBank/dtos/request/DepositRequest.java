package com.liteBank.dtos.request;

import com.liteBank.dtos.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class DepositRequest {

    private String senderAccountNumber;
    private String recipientAccountNumber;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
}