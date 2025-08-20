package com.liteBank.controller;

import com.liteBank.dtos.request.DepositRequest;
import com.liteBank.dtos.response.DepositResponse;
import com.liteBank.dtos.response.ErrorResponse;
import com.liteBank.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1account")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestBody DepositRequest depositRequest) {
        try {
            DepositResponse depositResponse = accountService.deposit(depositRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(depositResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse<>(e.getMessage()));
        }
    }


}
