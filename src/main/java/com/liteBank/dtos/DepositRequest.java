package com.liteBank.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class DepositRequest {

    private String senderAccountNumber;
    private String recipientAccountNumber;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
}