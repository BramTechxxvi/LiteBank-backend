package com.liteBank.dtos.response;

import com.liteBank.dtos.enums.TransactionType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TransactionResponse {
    @Id
    private String id;
    private String amount;
    private TransactionType transactionType;
}