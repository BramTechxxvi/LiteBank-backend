package com.liteBank.dtos;

import java.math.BigDecimal;

public class DepositRequest {

    private String senderAccountNumber;
    private String recipientAccountNumber;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
}
